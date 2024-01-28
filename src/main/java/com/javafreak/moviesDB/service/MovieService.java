package com.javafreak.moviesDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafreak.moviesDB.repo.Movie;
import com.javafreak.moviesDB.repo.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }
    public Movie findMovieByImdbId(String imdbId) {
        return repository.findMovieByImdbId(imdbId);
    }
}
