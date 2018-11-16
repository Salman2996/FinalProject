package com.finalproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "favourites")
public class Favourites {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="favourite_sequence")
	@SequenceGenerator(name="favourite_sequence",sequenceName="FAVOURITE_SEQ",allocationSize=1)
	//@Column(name="fav_id")
	private Long id;
	
	@Column(name="imdbid")
	private String imdbId;
	
	@Column(name = "title")
	private String title; 
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "poster")
	String poster;

	@Column(name = "type")
	String type;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User user;
	
	public Favourites(){}
	
	public Favourites(String imdbid, String title, String year, String poster,String type) {
		this.imdbId = imdbid;
		this.title = title;
		this.year = year;
		this.poster = poster;
		this.type = type;
	}
	
//	public Long getFav_id() {
//		return fav_id;
//	}
//
//	public void setFav_id(Long fav_id) {
//		this.fav_id = fav_id;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getImdbid() {
		return imdbId;
	}

	public void setImdbid(String imdbid) {
		this.imdbId = imdbid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Favourites )) return false;
        return id != null && id.equals(((Favourites) o).id);
	}
	 @Override
	    public int hashCode() {
	        return 31;
	    }

}