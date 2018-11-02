package com.finalproject.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.finalproject.service.FavouriteService;

@Service
public class FavouriteServiceImpl implements FavouriteService {

	ArrayList<Favourites> favourites;
	
	public FavouriteServiceImpl() {
		favourites = new ArrayList<Favourites>();
		favourites.add(new Favourites(1, "deadpool", "english", 2.5));
		favourites.add(new Favourites(2, "ironman", "english", 2.5));
		favourites.add(new Favourites(3, "spiderman", "english", 2.5));
	}
	
	@Override
	public List<Favourites> getFavourites() {
		return favourites;
	}
	
	@Override
	public Favourites getFavouriteById(String id) {
		return favourites.get(Integer.parseInt(id));
	}

	@Override
	public void addFavourite(Favourites favourite) {
		favourites.add(favourite);
	}

	@Override
	public void updateFavourite(String id, Favourites favourite) {
		/*Favourites updateFavourite = this.getFavouriteById(id);
		updateFavourite.setMovieName(favourite.getMovieName());
		updateFavourite.setMovieLanguage(favourite.getMovieLanguage());
		updateFavourite.setMovieDuration(favourite.getMovieDuration());*/
		favourites.set(Integer.parseInt(id), favourite);
	}

	@Override
	public void removeFavourite(String id) {
		favourites.remove(Integer.parseInt(id));
	}

}
