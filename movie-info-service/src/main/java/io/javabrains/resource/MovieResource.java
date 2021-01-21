package io.javabrains.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.models.Movie;

@RestController
@RequestMapping("/movie")
public class MovieResource {

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId)
	{
		System.out.println("second microservices call");
		return new Movie(movieId,"Test Name");
		
	}
}
