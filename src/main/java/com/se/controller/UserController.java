package com.se.controller;



import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.User;
import com.se.service.UserServices;

import ch.qos.logback.classic.Logger;

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
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("users-paging")
	public Page<User> getAllUser_Paging(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size, @RequestParam String keyword) {
		 Pageable pageable = PageRequest.of(page, size);
		 Page<User> pageuser  = null; 
		 System.out.println("kw = "+keyword);
		if (keyword.equalsIgnoreCase("") == false) {
			 pageuser = userServices.getAllUser_Paging(keyword, pageable);
		} else {
			System.out.println("tjh2");
			pageuser = userServices.getAllUser_Paging(pageable);
		}
		 
		 return pageuser;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("checkuser")
	public User getUserLogin(@RequestParam String token) {
		System.out.println("token = " +token);
		return userServices.getCurrentAuthenticatedUser(token);
	}
	
}
