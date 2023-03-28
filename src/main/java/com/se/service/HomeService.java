package com.se.service;

import java.util.List;
import java.util.UUID;

import com.se.entity.Home;

public interface HomeService {
	public List<Home> getAllHome();
	public Home getHomeById(UUID uuid);
	public void saveHome(Home home);
	public void deleteById(UUID uuid);
	
	public List<Home> getHome_SellByIDUser();
	public List<Home> getHome_RentByIDUser();
}
