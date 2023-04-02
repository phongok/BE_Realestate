package com.se.service;

import java.util.List;
import java.util.UUID;

import com.se.entity.RealEstate;

public interface RealEstateService {
	public List<RealEstate> getAllHome();
	public RealEstate getHomeById(long id);
	public void saveHome(RealEstate home);
	public void deleteById(long uuid);
	
	public List<RealEstate> getHome_Sell();
	public List<RealEstate> getHome_Rent();
}
