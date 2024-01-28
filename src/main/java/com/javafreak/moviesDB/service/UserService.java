package com.javafreak.moviesDB.service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.javafreak.moviesDB.model.UserDTO;
import com.javafreak.moviesDB.repo.Movie;
import com.javafreak.moviesDB.repo.MovieRepository;
import com.javafreak.moviesDB.repo.Review;
import com.javafreak.moviesDB.repo.User;
import com.javafreak.moviesDB.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public String createUser(String name, String email, String password) {
		String response = "Failed";
		try {
			User user = userRepo.insert(new User(name, email, password));
			response = "User Created Successfully : " + user.getName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public UserDTO getUser(String email, String password) {
		User user = userRepo.findUserByEmailAndPassword(email, password);
		if (null != user) {
			return new UserDTO(user.getName(), user.getEmail(), user.getWatchList());

		}
		return null;
	}

	public String updateWatchlist(String userEmail, String imdbId, String operation) {

		if (operation.equalsIgnoreCase("ADD"))
			mongoTemplate.update(User.class).matching(Criteria.where("email").is(userEmail))
					.apply(new Update().push("watchList").value(imdbId)).first();
		else if (operation.equalsIgnoreCase("REMOVE"))
			mongoTemplate.update(User.class).matching(Criteria.where("email").is(userEmail))
					.apply(new Update().pull("watchList", imdbId)).first();
		else
			System.out.println("Invalid Operation");

		return null;
	}
}
