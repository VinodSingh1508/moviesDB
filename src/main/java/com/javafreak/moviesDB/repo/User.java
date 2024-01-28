package com.javafreak.moviesDB.repo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "users")
public class User {
    @Id
    private ObjectId id;
    private String name;
    private String email;
    private String password;
    private List<String> watchList;
    
    public User() {
    	super();
    }
    
	public User(ObjectId id, String name, String email, String password, List<String> watchList) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.watchList=watchList;
	}
    
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getWatchList() {
		return watchList;
	}

	public void setWatchList(List<String> watchList) {
		this.watchList = watchList;
	}
    
}