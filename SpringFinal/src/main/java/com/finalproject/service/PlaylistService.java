package com.finalproject.service;

import java.util.List;

import com.finalproject.model.Playlist;

public interface PlaylistService {
	public List<Playlist> getPlaylist(int id);
	public void addPlaylist(Playlist playlist, int id);
	public boolean checkIfPlaylistExists(String playlist, int user_id);
}
