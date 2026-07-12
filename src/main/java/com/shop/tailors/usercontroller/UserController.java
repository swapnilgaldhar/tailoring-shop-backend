package com.shop.tailors.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.tailors.entity.User;
import com.shop.tailors.userservice.UserService;

@RestController
@RequestMapping("/tailors/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		userService.registerUser(user);
		return new ResponseEntity<String>("User created", HttpStatus.CREATED);
	}

}
