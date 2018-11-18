package com.finalproject.controller;

import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.model.Favourites;
import com.finalproject.service.FavouriteService;
@CrossOrigin(origins = "*")
@RestController
public class FavouriteController {
	
	@Autowired
	FavouriteService favouriteService;
	
	// Angular request to display favourites comes here to get the favourites
	@GetMapping(value = "/api/favourites/{id}")
	public List<Favourites> getFavourites(@PathVariable(value="id") String id){
		System.out.println("Fetching favourites");
		return favouriteService.getFavourites(Integer.parseInt(id));
	}
	
	
	// Clicking add button should redirect the request here
	@PostMapping(value = "/api/addFavourite/{user_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addFavourite(@RequestBody String favourite, @PathVariable(value = "user_id") String id){
		
		// System.out.println("received" + favourite);
		try {
			JSONObject jsonObject = new JSONObject(favourite);
			String imdbID = jsonObject.getString("imdbID");
			
			if(!favouriteService.checkIfAlreadyInFavourites(imdbID, id)) {
				
				String title = jsonObject.getString("Title");
				String year = jsonObject.getString("Year");
				String poster = jsonObject.getString("Poster");
				String type = jsonObject.getString("Type");
				
				Favourites newFavourite = new Favourites(imdbID, title, year, poster, type);
				favouriteService.addFavourite(newFavourite, id);
			} else {
				System.out.println("Already in favourites!!");
				return null;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return favourite;
	}
	
	// Clicking remove button should redirect the request here
	@DeleteMapping(path= "/api/removeFavourite/{user_id}/{imdb_id}")
	public void removeProduct(@PathVariable(value = "imdb_id") String imdb_id, @PathVariable(value = "user_id") String user_id){
		favouriteService.removeFavourite(imdb_id,user_id);
	}
}