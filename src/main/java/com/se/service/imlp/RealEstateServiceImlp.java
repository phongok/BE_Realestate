package com.se.service.imlp;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.entity.RealEstate;
import com.se.repository.RealEstateRepository;
import com.se.service.RealEstateService;


@Service
public class RealEstateServiceImlp implements RealEstateService {
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	
	@Override
	public List<RealEstate> getAllHome() {
		// TODO Auto-generated method stub
		return realEstateRepository.findAll();
	}

	@Override
	public RealEstate getHomeById(long id) {
		// TODO Auto-generated method stub
		Optional<RealEstate> result =  realEstateRepository.findById(id);
		RealEstate home = null;
		if (result.isPresent()) {
			home = result.get();
		}
		else {
			throw new RuntimeException("Did not find home id = "+id);
		}
		return home;
	}

	@Override
	public void saveHome(RealEstate home) {
		// TODO Auto-generated method stub
		realEstateRepository.save(home);
		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		realEstateRepository.deleteById(id);
		
	}

	@Override
	public List<RealEstate> getHome_Sell() {
		// TODO Auto-generated method stub
		return realEstateRepository.getHomeSell();
	}

	@Override
	public List<RealEstate> getHome_Rent() {
		// TODO Auto-generated method stub
		return realEstateRepository.getHomeRent();
	}

	
	
	
}
