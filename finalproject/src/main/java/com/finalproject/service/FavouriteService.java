package com.finalproject.service;

import java.util.List;

import com.finalproject.model.Favourites;

public interface FavouriteService {
	public List<Favourites> getFavourites();
	public Favourites getFavouriteById(String id);
	public void addFavourite(Favourites favourite);
	public void updateFavourite(String id, Favourites favourite);
	public void removeFavourite(String id);
}
