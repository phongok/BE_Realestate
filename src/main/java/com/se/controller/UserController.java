package com.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.User;
import com.se.service.UserServices;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("users/{username}")
	public User getUserByUserName(@PathVariable String username) {
		
		return userServices.getUserByUserName(username);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("users/count")
	public String getAccountNumber() {
		return userServices.getUserNumber()+"";
	}
}
