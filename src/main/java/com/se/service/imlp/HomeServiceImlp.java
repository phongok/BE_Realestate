package com.se.service.imlp;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.entity.Home;
import com.se.repository.HomeRepository;
import com.se.service.HomeService;


@Service
public class HomeServiceImlp implements HomeService {
	@Autowired
	private HomeRepository homeRepository;
	
	
	@Override
	public List<Home> getAllHome() {
		// TODO Auto-generated method stub
		return homeRepository.findAll();
	}

	@Override
	public Home getHomeById(UUID uuid) {
		// TODO Auto-generated method stub
		Optional<Home> result =  homeRepository.findById(uuid);
		Home home = null;
		if (result.isPresent()) {
			home = result.get();
		}
		else {
			throw new RuntimeException("Did not find home id = "+uuid);
		}
		return home;
	}

	@Override
	public void saveHome(Home home) {
		// TODO Auto-generated method stub
		homeRepository.save(home);
		
	}

	@Override
	public void deleteById(UUID uuid) {
		// TODO Auto-generated method stub
		homeRepository.deleteById(uuid);
		
	}

	@Override
	public List<Home> getHome_SellByIDUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Home> getHome_RentByIDUser() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
