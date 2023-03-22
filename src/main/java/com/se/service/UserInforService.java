package com.se.service;

import java.util.List;

import com.se.entity.UserInfor;

public interface UserInforService {
	public List<UserInfor> getAllUserInfor();
	public UserInfor getInforUserById(long id);
	public void saveInforUser(UserInfor userInfor);
	
}
