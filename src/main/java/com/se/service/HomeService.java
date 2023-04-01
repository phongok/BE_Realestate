package com.se.service;

import java.util.List;
import java.util.UUID;

import com.se.entity.Home;

public interface HomeService {
	public List<Home> getAllHome();
	public Home getHomeById(long id);
	public void saveHome(Home home);
	public void deleteById(long uuid);
	
	public List<Home> getHome_Sell();
	public List<Home> getHome_Rent();
}
