package com.finalproject.service;

import java.util.List;
import java.util.Optional;

import com.finalproject.model.Favourites;

public interface FavouriteService {
	public List<Favourites> getFavourites(int id);
	//public Optional<Favourites> getFavouriteById(Long id);
	public void addFavourite(Favourites favourite,String id);
	//public void updateFavourite(String id, Favourites favourite);
	public void removeFavourite(String id,String user_id);
	public boolean checkIfAlreadyInFavourites(String imdbID, String id);
	public Optional<Favourites> getFavouriteByImdbId(String imdbId);
}