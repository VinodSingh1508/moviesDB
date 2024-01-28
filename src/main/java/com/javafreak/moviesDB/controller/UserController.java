package com.javafreak.moviesDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javafreak.moviesDB.model.UserDTO;
import com.javafreak.moviesDB.repo.Movie;
import com.javafreak.moviesDB.repo.Review;
import com.javafreak.moviesDB.service.MovieService;
import com.javafreak.moviesDB.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/getUser")
    public ResponseEntity<UserDTO> getUser(@RequestBody Map<String, String> payload){
    	UserDTO user=service.getUser(payload.get("email"), payload.get("pass"));
    	if(null!=user)
    		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    	else
    		return new ResponseEntity<UserDTO>(user, HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<String>(service.createUser(payload.get("name"), payload.get("email"), payload.get("pass")), HttpStatus.OK);
    }
    
    @PostMapping("/watchlist")
    public ResponseEntity<String> watchlist(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<String>(service.updateWatchlist(payload.get("user"), payload.get("imdbId"), payload.get("operation")), HttpStatus.OK);
    }
}
