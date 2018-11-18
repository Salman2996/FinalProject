package com.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.model.User;
import com.finalproject.service.LoginService;

@CrossOrigin(origins="*")
@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping(value = "/api/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public int getUser(@RequestBody User user) {
		System.out.println("Entered rest controller" + user.getEmail() + user.getPassword());
		int userID = loginService.getUser(user);
		return userID;

	}

	@PostMapping(value = "/api/addUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public int addUser(@RequestBody User user) {
		System.out.println(user.getEmail() + user.getFirstname() + user.getLastname() + user.getPassword() + "Phone="
				+ user.getPhone());
		loginService.addUser(user);
		return user.getId();
	}

}
