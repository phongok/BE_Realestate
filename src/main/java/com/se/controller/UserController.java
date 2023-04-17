package com.se.controller;



import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.User;
import com.se.service.UserServices;

import ch.qos.logback.classic.Logger;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	
	@GetMapping("users/{username}")
	public User getUserByUserName(@PathVariable String username) {
		
		return userServices.getUserByUserName(username);
	}
	
	@GetMapping("users/count")
	public String getAccountNumber() {
		return userServices.getUserNumber()+"";
	}
	
	
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
	
	
	@GetMapping("checkuser")
	public User getUserLogin(@RequestParam String token) {
		System.out.println("token = " +token);
		return userServices.getCurrentAuthenticatedUser(token);
	}
	
	
	@PostMapping("deductmoneypost")
	public void Deductmoneywhenpost(@RequestParam long idUser) {
		
		userServices.Deductmoneywhenposting(idUser);
	}
	
}
