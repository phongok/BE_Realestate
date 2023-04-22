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
	
	public Page<RealEstate> getHome_Sell(Pageable pageable);
	public Page<RealEstate> getHome_Rent(Pageable pageable);
	
	public int getRealEstateNumber();
	
	public Page<RealEstate> getAllRealState_Paging(Pageable pageable);
	
	
	public Page<RealEstate> getRealStateByUserID(long iduser, Pageable pageable) ;
	
	public Page<RealEstate> getRealStateByNewsTypeID(long idNews, Pageable pageable) ;
	
	
	
	
	public Page<RealEstate> getRealStateArea(String area, Pageable pageable) ;
	public Page<RealEstate> getRealStatePrice(long min, long max, Pageable pageable) ;
	public Page<RealEstate> getRealStateAcreage(float min, float max, Pageable pageable) ;
	
}
