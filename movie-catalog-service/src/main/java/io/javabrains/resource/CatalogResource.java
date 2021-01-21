package io.javabrains.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.models.CatalogItem;
import io.javabrains.models.Movie;
import io.javabrains.models.UserRating;
@RestController
@RequestMapping("/catalog")
public class CatalogResource {
 
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/{userid}")
	public List<CatalogItem> getCatalog(@PathVariable("userid") String userId) {
		UserRating ratings =restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+userId, UserRating.class);
		 return ratings.getUserRating().stream().map(rating ->{
	                    Movie movie = restTemplate.getForObject("http://movie-info-service/movie/"+rating.getMovieId(), Movie.class);
	                    return new CatalogItem(movie.getName(), "Test", rating.getRating());
	                }).collect(Collectors.toList());
		}
}


