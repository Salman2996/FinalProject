package com.finalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.finalproject.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
	public User findByEmail(String email);
}
