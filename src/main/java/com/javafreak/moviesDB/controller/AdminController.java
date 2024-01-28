package com.javafreak.moviesDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafreak.moviesDB.repo.Movie;
import com.javafreak.moviesDB.service.AdminService;

@RestController
@RequestMapping("/api/v1/admin/movies")
public class AdminController {

	@Autowired
    private AdminService adminService;

	@PostMapping
    public ResponseEntity<List<Movie>> addOrUpdateMovies(@RequestBody List<Movie> movies) {
        List<Movie> savedMovies = adminService.addOrUpdateMovies(movies);
        return new ResponseEntity<>(savedMovies, HttpStatus.OK);
    }
	@DeleteMapping
	public ResponseEntity<List<String>> deleteMovies(@RequestBody List<String> imdbIds) {
        List<String> deletedIds = adminService.deleteMovies(imdbIds);
        return new ResponseEntity<>(deletedIds, HttpStatus.OK);
    }
}