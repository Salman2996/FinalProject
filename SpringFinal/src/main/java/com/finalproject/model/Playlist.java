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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "playlist")
public class Playlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playlist_sequence")
	@SequenceGenerator(name = "playlist_sequence", sequenceName = "PLAYLIST_SEQ", allocationSize = 1)
	private Long id;
	
	@Column(name = "playlist_name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	public Playlist(String name){
		this.name = name;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Playlist))
			return false;
		return id != null && id.equals(((Playlist) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}
	
}
