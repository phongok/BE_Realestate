package com.se.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.se.entity.UserInfor;
import com.se.service.UserInforService;

@RequestMapping("/api")
@RestController
public class UserControler {
	
	@Autowired
	private UserInforService userInforService;
	
	@PostMapping("/userinfors")
	public UserInfor createUserInfor (@RequestBody UserInfor userInfor) {
		userInforService.saveInforUser(userInfor);
		return userInfor;
	}
	
	@PutMapping("/userinfors")
	public UserInfor updateUserInfor (@RequestBody UserInfor userInfor) {
		userInforService.saveInforUser(userInfor);
		return userInfor;
	}
		
	@GetMapping("/userinfors")
	public List<UserInfor> listUserInfor() {
		List<UserInfor> userInfors =  userInforService.getAllUserInfor();
		return userInfors;
	}
	
	@GetMapping("userinfors/{id}")
	public UserInfor findOnePlant(@PathVariable long id) {
		UserInfor userInfor = userInforService.getInforUserById(id);
		return userInfor;
	}
}
