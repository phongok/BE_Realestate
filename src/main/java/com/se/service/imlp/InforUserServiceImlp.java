package com.se.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.entity.UserInfor;
import com.se.repository.UserInforRepository;
import com.se.service.UserInforService;
@Service
public class InforUserServiceImlp implements UserInforService {

	@Autowired
	private UserInforRepository userInforRepository;
	
	@Override
	public List<UserInfor> getAllUserInfor() {
		// TODO Auto-generated method stub
		return userInforRepository.findAll();
	}

	@Override
	public UserInfor getInforUserById(long id) {
		// TODO Auto-generated method stub
		Optional<UserInfor> result = userInforRepository.findById(id);
		UserInfor userInfor = null;
		if (result.isPresent()) {
			userInfor = result.get();
		} else {
			throw new RuntimeException("Did not find UserInfor id="+ id);
		}
		return userInfor;
	}

	@Override
	public void saveInforUser(UserInfor userInfor) {
		// TODO Auto-generated method stub
		userInforRepository.save(userInfor);
		
	}
	
}
