package com.se.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.se.entity.NewsType;

public interface NewsTypeService {
	
	
	
	public List<NewsType> getAllNewsTypeSell();
	public List<NewsType> getAllNewsTypeRent();

	public NewsType getNewsTypeById(long theId) ;
	public void saveNewsType(NewsType typeofsale);
	
	public int getNewsTypeNumber();
	
	public Page<NewsType> getAllNewsPage_Paging(String keyword, Pageable pageable) ;
	public Page<NewsType> getAllNewsPage_Paging( Pageable pageable) ;
	
	public NewsType LockNewsType(long id) ;
	
	public List<NewsType> getAllNewsType();
}
