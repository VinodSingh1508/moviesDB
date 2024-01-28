package com.javafreak.moviesDB.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
	User findUserByEmailAndPassword(String email, String password);
	User findUserByEmail(String email);
}
