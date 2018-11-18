package com.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.model.Playlist;
import com.finalproject.service.PlaylistService;

@CrossOrigin(origins = "*")
@RestController
public class PlaylistController {

	@Autowired
	PlaylistService playlistService;

	@GetMapping(value = "/api/playlist/{user_id}")
	public List<Playlist> getPlaylist(@PathVariable(value = "user_id") String id) {
		System.out.println("Fetching playlist");
		return playlistService.getPlaylist(Integer.parseInt(id));
	}

	@PostMapping(value = "/api/addPlaylist/{user_id}/{playlist_name}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addPlaylist(@PathVariable(value = "user_id") String id, @PathVariable(value = "playlist_name") String playlist) {

		System.out.println("received" + playlist);
		if(!playlistService.checkIfPlaylistExists(playlist, Integer.parseInt(id))) {
			Playlist newPlaylist = new Playlist(playlist);
			playlistService.addPlaylist(newPlaylist, Integer.parseInt(id));
			return playlist;
		}
		System.out.println("Playlist exists!!");
		return null;
	}

}
