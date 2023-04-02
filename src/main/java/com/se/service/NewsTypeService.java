package com.se.service;

import java.util.List;

import com.se.entity.NewsType;

public interface NewsTypeService {
	
	public List<NewsType> getAllNewsType();
	
	public List<NewsType> getAllNewsTypeSell();
	public List<NewsType> getAllNewsTypeRent();

	public NewsType getNewsTypeById(long theId) ;
	public void saveNewsType(NewsType typeofsale);
}
