package com.finalproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.model.Favourites;
import com.finalproject.model.User;
import com.finalproject.repository.FavouriteRepository;
import com.finalproject.repository.UserRepository;
import com.finalproject.service.FavouriteService;

@Service
public class FavouriteServiceImpl implements FavouriteService {

	ArrayList<Favourites> favourites;

	@Autowired
	FavouriteRepository favouriteRepository;

	@Autowired
	UserRepository userRepository;

	public FavouriteServiceImpl() {
		favourites = new ArrayList<Favourites>();
	}

	@Override
	public List<Favourites> getFavourites(int id) {
		return (List<Favourites>) favouriteRepository.findAllByUserId(id);
	}

	@Override
	public Optional<Favourites> getFavouriteById(Long id) {
		return favouriteRepository.findById(id);
	}

	@Override
	public void addFavourite(Favourites favourite, String id) {
		Favourites fav = new Favourites();
		Optional<User> user;
		user = userRepository.findById(Integer.parseInt(id));
		User userFound = user.get();
		favourite.setUser(userFound);
//		userRepository.findById(Integer.parseInt(id))).map(user -> {
//			favourite.setUser(user);
//            return commentRepository.save(comment);
//        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + id + " not found"));
		favouriteRepository.save(favourite);
	}

	@Override // NOT NEEDED, DELETE THIS
	public void updateFavourite(String id, Favourites favourite) {
		/*
		 * Favourites updateFavourite = this.getFavouriteById(id);
		 * updateFavourite.setMovieName(favourite.getMovieName());
		 * updateFavourite.setMovieLanguage(favourite.getMovieLanguage());
		 * updateFavourite.setMovieDuration(favourite.getMovieDuration());
		 */
		favourites.set(Integer.parseInt(id), favourite);
	}

	@Override
	@Transactional
	public void removeFavourite(String imdbId, String user_id) {
		List<Favourites> fav = favouriteRepository.findAllByUserId(Integer.parseInt(user_id));
		for (Favourites favourite : fav) {
			if(favourite.getImdbid().equals(imdbId)) {
				favouriteRepository.deleteByImdbId(imdbId);
				break;
			}
		}
		
	}

	@Override
	public boolean checkIfAlreadyInFavourites(String imdbID) {
		if (getFavouriteByImdbId(imdbID) == null)
			return true;
		return false;
	}

	@Override
	public Optional<Favourites> getFavouriteByImdbId(String imdbId) {
		return favouriteRepository.findByImdbId(imdbId);
	}

}