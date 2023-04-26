package com.se.service;





import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.se.dto.UserDTO;

import com.se.entity.User;
import com.se.entity.UserPrincipal;

public interface UserServices {
	public User saveUser(UserDTO u);

	public UserPrincipal getUserByUsername(String username);
	
	public User getUserByUserName(String username);
	
	public int getUserNumber();
	
	public Page<User> getAllUser_Paging(String keyword, Pageable pageable);
	public Page<User> getAllUser_Paging( Pageable pageable);
	
	
	User getCurrentAuthenticatedUser(String token);
	
	void Deductmoneywhenposting(long id);
	
	
	public Page<User> getAllUserLock(String keyword, Pageable pageable);
	public Page<User> getAllUserLock( Pageable pageable);
	
	public User unlockUser(long id);
	
	public User lockUser(long id);
	
	public User PublicMoney(long id, double money) ;
	
	
}
