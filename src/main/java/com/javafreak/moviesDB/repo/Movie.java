package com.javafreak.moviesDB.repo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> backdrops;
    private List<String> genres;
    @DocumentReference
    private List<Review> reviews;

    private String imdbLink;
    private Double imdbRating;
    private String plot;
    private String runTime;
    private List<String> director;
    private List<String> cast;

    
	
    public Movie(ObjectId id, String imdbId, String title, String releaseDate, String trailerLink, String poster,
			List<String> backdrops, List<String> genres, List<Review> reviews, String imdbLink, Double imdbRating,
			String plot, String runTime, List<String> director, List<String> cast) {
		super();
		this.id = id;
		this.imdbId = imdbId;
		this.title = title;
		this.releaseDate = releaseDate;
		this.trailerLink = trailerLink;
		this.poster = poster;
		this.backdrops = backdrops;
		this.genres = genres;
		this.reviews = reviews;
		this.imdbLink = imdbLink;
		this.imdbRating = imdbRating;
		this.plot = plot;
		this.runTime = runTime;
		this.director = director;
		this.cast = cast;
	}


/*
    public Movie(String imdbId, String title, String releaseDate, String trailerLink, String poster, List<String> backdrops, List<String> genres) {
        this.imdbId = imdbId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
        this.poster = poster;
        this.backdrops = backdrops;
        this.genres = genres;
    }
*/
	public Movie() {
		super();
	}


	public ObjectId getId() {
		return id;
	}


	public void setId(ObjectId id) {
		this.id = id;
	}


	public String getImdbId() {
		return imdbId;
	}


	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public String getTrailerLink() {
		return trailerLink;
	}


	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}


	public String getPoster() {
		return poster;
	}


	public void setPoster(String poster) {
		this.poster = poster;
	}


	public List<String> getBackdrops() {
		return backdrops;
	}


	public void setBackdrops(List<String> backdrops) {
		this.backdrops = backdrops;
	}


	public List<String> getGenres() {
		return genres;
	}


	public void setGenres(List<String> genres) {
		this.genres = genres;
	}


	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	public String getImdbLink() {
		return imdbLink;
	}


	public void setImdbLink(String imdbLink) {
		this.imdbLink = imdbLink;
	}


	public Double getImdbRating() {
		return imdbRating;
	}


	public void setImdbRating(Double imdbRating) {
		this.imdbRating = imdbRating;
	}


	public String getPlot() {
		return plot;
	}


	public void setPlot(String plot) {
		this.plot = plot;
	}


	public String getRunTime() {
		return runTime;
	}


	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}


	public List<String> getDirector() {
		return director;
	}


	public void setDirector(List<String> director) {
		this.director = director;
	}


	public List<String> getCast() {
		return cast;
	}


	public void setCast(List<String> cast) {
		this.cast = cast;
	}
    
}



