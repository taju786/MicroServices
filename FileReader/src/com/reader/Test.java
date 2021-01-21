package com.reader;

public class Test {

	public static void main(String[] args) {
		String path = "D://fileread//LoginController.txt";
		path = path.substring(path.lastIndexOf("//") + 2);
		path = path.substring(0, path.indexOf("."));
		
		
		String sampleString = "C:\\program\\example.txt";
		sampleString = sampleString.substring(sampleString.lastIndexOf("\\") + 1);
		sampleString = sampleString.substring(0, sampleString.indexOf("."));
		System.out.println("sampleString "+sampleString);
	}

}
