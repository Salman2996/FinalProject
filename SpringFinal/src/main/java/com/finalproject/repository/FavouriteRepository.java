package com.finalproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.finalproject.model.Favourites;

@Repository
public interface FavouriteRepository extends CrudRepository<Favourites, String> {

	Optional<Favourites> findByImdbId(String imdbId);
	void deleteByImdbId(String imdbId);
	List<Favourites> findAllByUserId(int user_id);
}
