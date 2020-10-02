package com.demo.movie.movieinfoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.movie.movieinfoservice.model.Movie;
import com.demo.movie.movieinfoservice.model.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	@Value("${tmdb.api.key}")
	private String tmdbApiKey;

	@Value("${tmdb.api.url}")
	private String tmdbApiUrl;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		MovieSummary movieSummary = restTemplate.getForObject(tmdbApiUrl + movieId + "?api_key=" + tmdbApiKey,
				MovieSummary.class);
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}
}
