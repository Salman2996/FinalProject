package com.finalproject.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.org.apache.xpath.internal.FoundIndex;

@Entity
@Table(name = "UserTable")
public class User {

	
	
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE")
	private String phone;

	@Column(name="PASSWORD")
	private String password;
	
	//@OneToMany(mappedBy="user")
	//private Set<Favourites> favourites;
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
//	public Set<Favourites> getFavourites() {
//		return favourites;
//	}
//	public void setFavourites(Set<Favourites> favourites) {
//		this.favourites = favourites;
//	}
	public User() {
		
	}
	public User(int id,String firstName, String lastName, String email, String password,String phone) {
		super();
		this.id=id;
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		this.password = password;
		this.phone= phone;
	}
	public User(String firstName, String lastName, String email, String password,String phone) {
		super();
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		this.password = password;
		this.phone= phone;
	}




	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}




	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}
	
	
//	public void addFavourite(Favourites favourite) {
//		this.favourites.add(favourite);
//		favourite.setUser(this);
//	}
//	
//	public void removeFavourite(Favourites favourite) {
//		this.favourites.remove(favourite);
//		favourite.setUser(null);
//	}
	
	
}
