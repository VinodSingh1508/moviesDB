package com.javafreak.moviesDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafreak.moviesDB.repo.Movie;
import com.javafreak.moviesDB.service.MovieService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
    	List<Movie> s=service.findAllMovies();
        return new ResponseEntity<List<Movie>>(s, HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Movie> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Movie>(service.findMovieByImdbId(imdbId), HttpStatus.OK);
    }
    
    @GetMapping("/")
    public ResponseEntity<String> test(){
        return new ResponseEntity<String>("Hey there!!!", HttpStatus.OK);
    }
}
