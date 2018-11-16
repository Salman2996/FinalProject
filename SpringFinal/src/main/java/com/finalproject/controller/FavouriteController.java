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
	
	//@RequestMapping("favourites")
	// Angular request to display favourites comes here to get the favourites
	@GetMapping(value = "/api/favourites/{id}")
	public List<Favourites> getFavourites(@PathVariable(value="id") String id){
		System.out.println("Fetching favourites");
		return favouriteService.getFavourites(Integer.parseInt(id));
	}
	
	@RequestMapping("favourite/{id}")
	public Optional<Favourites> getFavouriteById(@PathVariable String id){
		return favouriteService.getFavouriteById(Long.parseLong(id));
	}
	
	//@RequestMapping(value = "api/addFavourite", method = RequestMethod.POST)
	// Clicking add button should redirect the request here
	@PostMapping(value = "/api/addFavourite/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addFavourite(@RequestBody String favourite,@PathVariable(value="id") String id){
		
		System.out.println("received" + favourite);
		try {
			JSONObject jsonObject = new JSONObject(favourite);
			String imdbID = jsonObject.getString("imdbID");
			if(!favouriteService.checkIfAlreadyInFavourites(imdbID)) {
				String title = jsonObject.getString("Title");
				String year = jsonObject.getString("Year");
				String poster = jsonObject.getString("Poster");
				String type = jsonObject.getString("Type");
				//String user_id = jsonObject.getString("User_ID");
				
				Favourites newFavourite = new Favourites(imdbID, title, year, poster, type);
				favouriteService.addFavourite(newFavourite,id);
			} else {
				System.out.println("Already in favourites!!");
				return "Already in favourites";
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		//favouriteService.addFavourite(favourite);
		return favourite;
	}
	
	@RequestMapping(value = "updateFavourite/{id}", method = RequestMethod.PUT)
	public void updateFavourite(@PathVariable String id, @RequestBody Favourites favourite){
		favouriteService.updateFavourite(id, favourite);
	}
	
	//@RequestMapping(value = "/api/removeFavourite/{id}", method = RequestMethod.DELETE)
	// Clicking remove button should redirect the request here
	@DeleteMapping(path= "/api/removeFavourite/{user_id}/{id}")
	public void removeProduct(@PathVariable String id, @PathVariable String user_id){
		// TODO: Add @DeleteMapping annotation to this function, URL must be same as that in angular
		// TODO: Extract the movie ID from the post request
		// TODO: Delete the required movie from the collection (to be done in the service method)
		favouriteService.removeFavourite(id,user_id);
	}
}