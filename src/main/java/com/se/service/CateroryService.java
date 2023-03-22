package com.se.service;

import java.util.List;

import com.se.entity.Category;

public interface CateroryService {
	public List<Category> getAllCaterory();
	public Category getCaterory(long theId);
	public void saveCaterory(Category category);
}
