package com.finalproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.model.Favourites;
import com.finalproject.service.FavouriteService;

@RestController
public class FavouriteController {
	
	@Autowired
	FavouriteService favouriteService;
	
	@RequestMapping("favourites")
	// Angular request to display favourites comes here to get the favourites
	public List<Favourites> getFavourites(){
		// TODO: convert the data from collection to JSON and return it to angular
		return favouriteService.getFavourites();
	}
	
	@RequestMapping("favourite/{id}")
	public Favourites getFavouriteById(@PathVariable String id){
		return favouriteService.getFavouriteById(id);
	}
	
	@RequestMapping(value = "addFavourite", method = RequestMethod.POST)
	// Clicking add button should redirect the request here
	public void addFavourite(@RequestBody Favourites favourite){
		// TODO: Add @PostMapping annotation to this function, URL must be same as that in angular
		// TODO: Extract the movie ID from the post request and send a request to OMDB api to get the movie details
		// TODO: Add the required details to the collection (to be done in the service method)
		favouriteService.addFavourite(favourite);
	}
	
	@RequestMapping(value = "updateFavourite/{id}", method = RequestMethod.PUT)
	public void updateFavourite(@PathVariable String id, @RequestBody Favourites favourite){
		favouriteService.updateFavourite(id, favourite);
	}
	
	@RequestMapping(value = "removeFavourite/{id}", method = RequestMethod.DELETE)
	// Clicking remove button should redirect the request here
	public void removeProduct(@PathVariable String id){
		// TODO: Add @DeleteMapping annotation to this function, URL must be same as that in angular
		// TODO: Extract the movie ID from the post request
		// TODO: Delete the required movie from the collection (to be done in the service method)
		favouriteService.removeFavourite(id);
	}
}
