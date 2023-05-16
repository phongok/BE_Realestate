package com.se.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se.dto.UpdateInforDTO;
import com.se.dto.UserDTO;
import com.se.dto.UserUpdate;
import com.se.entity.Role;
import com.se.entity.User;
import com.se.service.UserServices;

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
		return userServices.getUserNumber() + "";
	}

	@GetMapping("users-paging")
	public Page<User> getAllUser_Paging(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam String keyword) {
		Pageable pageable = PageRequest.of(page, size);
		Page<User> pageuser = null;
		System.out.println("kw = " + keyword);
		if (keyword.equalsIgnoreCase("") == false) {
			pageuser = userServices.getAllUser_Paging(keyword, pageable);
		} else {
			System.out.println("tjh2");
			pageuser = userServices.getAllUser_Paging(pageable);
		}

		return pageuser;
	}

	@GetMapping("users-lock")
	public Page<User> getAllUser_Lock(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam String keyword) {
		Pageable pageable = PageRequest.of(page, size);
		Page<User> pageuser = null;
		System.out.println("kw = " + keyword);
		if (keyword.equalsIgnoreCase("") == false) {
			pageuser = userServices.getAllUserLock(keyword, pageable);
		} else {
			System.out.println("tjh2");
			pageuser = userServices.getAllUserLock(pageable);
		}

		return pageuser;
	}

	@GetMapping("checkuser")
	public User getUserLogin(@RequestParam String token) {
		System.out.println("token = " + token);
		return userServices.getCurrentAuthenticatedUser(token);
	}

	@PostMapping("deductmoneypost")
	public void Deductmoneywhenpost(@RequestParam long idUser) {

		userServices.Deductmoneywhenposting(idUser);
	}

	@PostMapping("unlockuser")
	public User unlockUser(@RequestParam long userid) {
		return userServices.unlockUser(userid);
	}

	@PostMapping("lockuser")
	public User lockUser(@RequestParam long userid) {
		return userServices.lockUser(userid);
	}

	@PostMapping("user/publicmoney")
	public User PublicMoney(@RequestParam long userid, @RequestParam double money) {
		return userServices.PublicMoney(userid, money);
	}

	@PostMapping("user/create")
	public User createUser(@RequestBody UserDTO u, @RequestParam long role) {
		return userServices.saveUser(u, role);
	}

	@PutMapping("user/update")
	public User updateUser(@RequestBody UserUpdate userUpdate
			, @RequestParam long roleUpdate) {
		
		return userServices.UpdateUser(userUpdate, roleUpdate);
	}
	
	@PutMapping("user/updateInfor")
	public User updateUserInfor(@RequestBody UpdateInforDTO userUpdate) {
		
		return userServices.UpdateInforUser(userUpdate);
	}
	
	@PostMapping("user/checkUser")
	public String checkUser(@RequestParam String userName) {
		return userServices.checkUser(userName);
	}
	
	@PostMapping("user/checkLock")
	public User checkLock(@RequestParam String userName) {
		return userServices.checkLock(userName);
	}
	
	
}
