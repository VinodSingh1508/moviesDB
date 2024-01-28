package com.javafreak.moviesDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.javafreak.moviesDB.repo.Movie;
import com.javafreak.moviesDB.repo.Review;
import com.javafreak.moviesDB.repo.ReviewRepository;
import com.javafreak.moviesDB.repo.User;
import com.javafreak.moviesDB.repo.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;
    
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId, String userEmail) {
    	User user=userRepo.findUserByEmail(userEmail);
        Review review = repository.insert(new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now(), user));

        mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(imdbId))
            .apply(new Update().push("reviews").value(review))
            .first();

        return review;
    }
}
