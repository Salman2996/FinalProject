package com.finalproject.service;

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

	@Autowired
	FavouriteRepository favouriteRepository;

	@Autowired
	UserRepository userRepository;

	public FavouriteServiceImpl() {}

	@Override
	public List<Favourites> getFavourites(int id) {
		return (List<Favourites>) favouriteRepository.findAllByUserId(id);
	}

	@Override
	public Optional<Favourites> getFavouriteByImdbId(String imdbId) {
		return favouriteRepository.findByImdbId(imdbId);
	}


	@Override
	public void addFavourite(Favourites favourite, String id) {
		Optional<User> user = userRepository.findById(Integer.parseInt(id));
		favourite.setUser(user.get());
		
		favouriteRepository.save(favourite);
	}

	@Override
	@Transactional
	public void removeFavourite(String imdbId, String user_id) {
		List<Favourites> favourites = favouriteRepository.findAllByUserId(Integer.parseInt(user_id));
		for (Favourites favourite : favourites) {
			if(favourite.getImdbid().equals(imdbId)) {
				favouriteRepository.deleteByImdbId(imdbId);
				break;
			}
		}
	}

	@Override
	public boolean checkIfAlreadyInFavourites(String imdbID, String user_id) {
		List<Favourites> favourites = favouriteRepository.findAllByUserId(Integer.parseInt(user_id));
		for (Favourites favourite : favourites) {
			if(favourite.getImdbid().equals(imdbID)) {
				return true;
			}
		}
		
		return false;
	}

}