package com.finalproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.finalproject.model.Playlist;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long>{

	List<Playlist> findAllByUserId(int user_id);
}
