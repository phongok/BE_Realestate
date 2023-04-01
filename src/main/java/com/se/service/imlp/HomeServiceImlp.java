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
	public Home getHomeById(long id) {
		// TODO Auto-generated method stub
		Optional<Home> result =  homeRepository.findById(id);
		Home home = null;
		if (result.isPresent()) {
			home = result.get();
		}
		else {
			throw new RuntimeException("Did not find home id = "+id);
		}
		return home;
	}

	@Override
	public void saveHome(Home home) {
		// TODO Auto-generated method stub
		homeRepository.save(home);
		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		homeRepository.deleteById(id);
		
	}

	@Override
	public List<Home> getHome_Sell() {
		// TODO Auto-generated method stub
		return homeRepository.getHomeSell();
	}

	@Override
	public List<Home> getHome_Rent() {
		// TODO Auto-generated method stub
		return homeRepository.getHomeRent();
	}

	
	
	
}
