package com.se.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.se.entity.RealEstate;
import com.se.entity.User;

public interface RealEstateService {
	public List<RealEstate> getAllHome();
	public RealEstate getHomeById(long id);
	public void saveHome(RealEstate home);
	public void deleteById(long uuid);
	
	public List<RealEstate> getHome_Sell();
	public List<RealEstate> getHome_Rent();
	
	public int getRealEstateNumber();
	
	public Page<RealEstate> getAllRealState_Paging(Pageable pageable);
}
