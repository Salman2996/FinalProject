package com.finalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.model.Playlist;
import com.finalproject.model.User;
import com.finalproject.repository.PlaylistRepository;
import com.finalproject.repository.UserRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	PlaylistRepository playlistRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Playlist> getPlaylist(int id) {
		return (List<Playlist>) playlistRepository.findAllByUserId(id);
	}

	@Override
	public void addPlaylist(Playlist playlist, int id) {
		Optional<User> user = userRepository.findById(id);
		playlist.setUser(user.get());
		
		playlistRepository.save(playlist);
	}

	@Override
	public boolean checkIfPlaylistExists(String playlist, int user_id) {
		List<Playlist> playlists = playlistRepository.findAllByUserId(user_id);
		if(playlists == null)
			return false;
		for(Playlist list : playlists) {
			if(list.getName().equalsIgnoreCase(playlist))
				return true;
		}
		return false;
	}

}
