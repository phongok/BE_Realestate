package com.se.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.se.dto.UserDTO;
import com.se.entity.RealEstate;
import com.se.entity.User;
import com.se.entity.UserPrincipal;

public interface UserServices {
	public User saveUser(UserDTO u);

	public UserPrincipal getUserByUsername(String username);
	
	public User getUserByUserName(String username);
	
	public int getUserNumber();
	
	public Page<User> getAllUser_Paging(Pageable pageable);
}
