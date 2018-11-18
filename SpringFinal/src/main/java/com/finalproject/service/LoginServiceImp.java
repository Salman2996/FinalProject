package com.finalproject.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.model.User;
import com.finalproject.repository.UserRepository;



@Service
public class LoginServiceImp implements LoginService {

	@Autowired
	private UserRepository userRepository;
	
	private int userID;

	@Override
	public int getUser(User login) {
		System.out.println("login "+login.getEmail()+"  "+login.getPassword());
		try {
			List<User> result = new ArrayList<User>();
			for (User user : userRepository.findAll()) {
				result.add(user);
			}
			boolean flag = false;
			for (Iterator iterator = result.iterator(); iterator.hasNext();) {
				User user = (User) iterator.next();
				System.out.println(user.getEmail()+"  "+user.getPassword());

				if (user.getEmail().equalsIgnoreCase(login.getEmail())
						&& user.getPassword().equals(login.getPassword())) {

					flag = true;
					userID = user.getId();
					System.out.println(userID);
					break;
				}
			}
			if (flag) {
				//userID = user.getId();
				System.out.println("User exist");
				return userID;	
			} else
			{
				System.out.println("user"+userID);
				System.out.println("User doesnt Exist"+"user");
				userID=0;
			}

		}catch (Exception e) {
			
			e.printStackTrace();
		}

		return userID;
	}

	@Override
	public int addUser(User user) {
		userRepository.save(user);
		User response=userRepository.findByEmail(user.getEmail());
		return response.getId();

	}


}
