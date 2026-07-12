package com.shop.tailors.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.tailors.entity.User;
import com.shop.tailors.userrepo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo; 

	public String registerUser(User user) {
		
		userRepo.save(user);
		return "UserCreated";
		// TODO Auto-generated method stub
		
	}
	
	

}
