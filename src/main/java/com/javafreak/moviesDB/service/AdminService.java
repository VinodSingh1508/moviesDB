package com.javafreak.moviesDB.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.javafreak.moviesDB.repo.Movie;
import com.javafreak.moviesDB.repo.MovieRepository;
import com.javafreak.moviesDB.repo.Review;
import com.javafreak.moviesDB.repo.ReviewRepository;

@Service
public class AdminService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private ReviewRepository reviewRepository;

	// https://medium.com/geekculture/types-of-update-operations-in-mongodb-using-spring-boot-11d5d4ce88cf

	public List<Movie> addOrUpdateMovies(List<Movie> movies) {
		List<Movie> updatedMovies = new ArrayList<>();
		for (Movie movie : movies) {
			Movie oldMovie = movieRepository.findMovieByImdbId(movie.getImdbId());
			if (null != oldMovie) {
				movie.setId(oldMovie.getId());
				movie.setReviews(oldMovie.getReviews());
			}
			updatedMovies.add(mongoTemplate.save(movie));
		}
		return updatedMovies;
	}

	public List<String> deleteMovies(List<String> imdbIds) {
		List<String> deletedIds = new ArrayList<>();
		for (String indbId : imdbIds) {
			Movie movie = movieRepository.findMovieByImdbId(indbId);
			if (movie != null) {
				deletedIds.add(indbId);
				for (Review review : movie.getReviews()) {
					reviewRepository.deleteById(review.getId());
				}
				movieRepository.deleteById(movie.getId());
			}
		}
		return deletedIds;
	}

}
