package com.javafreak.moviesDB.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "reviews")
public class Review {
    private ObjectId id;
    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;
    @DocumentReference
    private User user;

	public Review(String body, LocalDateTime created, LocalDateTime updated, User user) {
		super();
		this.body = body;
		this.created = created;
		this.updated = updated;
		this.user = user;
	}

	public Review(ObjectId id, String body, LocalDateTime created, LocalDateTime updated, User user) {
		super();
		this.id = id;
		this.body = body;
		this.created = created;
		this.updated = updated;
		this.user = user;
	}

	public Review() {
		super();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
