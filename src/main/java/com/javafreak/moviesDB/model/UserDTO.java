package com.javafreak.moviesDB.model;

import java.util.List;

public class UserDTO {
    private String name;
    private String email;
    private List<String> watchlist;
    
    public UserDTO() {
    	super();
    }
    
	public UserDTO(String name, String email, List<String> watchlist) {
		super();
		this.name = name;
		this.email = email;
		this.watchlist = watchlist;
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

	public List<String> getWatchlist() {
		return watchlist;
	}

	public void setWatchlist(List<String> watchlist) {
		this.watchlist = watchlist;
	}
}
