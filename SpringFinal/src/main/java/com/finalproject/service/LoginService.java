package com.finalproject.service;

import com.finalproject.model.User;

public interface LoginService {
	public int getUser(User login);

	public int addUser(User user);
}
