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
	public List<Favourites> getFavourites(){
		return favouriteService.getFavourites();
	}
	
	@RequestMapping("favourite/{id}")
	public Favourites getFavouriteById(@PathVariable String id){
		return favouriteService.getFavouriteById(id);
	}
	
	@RequestMapping(value = "addFavourite", method = RequestMethod.POST)
	public void addFavourite(@RequestBody Favourites favourite){
		favouriteService.addFavourite(favourite);
	}
	
	@RequestMapping(value = "updateFavourite/{id}", method = RequestMethod.PUT)
	public void updateFavourite(@PathVariable String id, @RequestBody Favourites favourite){
		favouriteService.updateFavourite(id, favourite);
	}
	
	@RequestMapping(value = "removeFavourite/{id}", method = RequestMethod.DELETE)
	public void removeProduct(@PathVariable String id){
		favouriteService.removeFavourite(id);
	}
}
