package com.finalproject.model;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;*/

/*@Entity
@Table(name = "FAVROURITES")*/
public class Favourites {
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favourite_sequence")
	@SequenceGenerator(name = "favourite_sequence", sequenceName = "fav_seq", allocationSize = 1)*/
	private Integer id;
	
	//@Column(name = "movie_name")
	private String movieName; 
	
	//@Column(name = "movie_language")
	private String movieLanguage;
	
	//@Column(name = "movie_duration")
	double movieDuration;

	public Favourites(Integer id, String movieName, String movieLanguage, double movieDuration) {
		this.id = id;
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.movieDuration = movieDuration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public double getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(double movieDuration) {
		this.movieDuration = movieDuration;
	}
	
}
