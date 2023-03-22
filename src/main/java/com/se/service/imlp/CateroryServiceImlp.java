package com.se.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.entity.Category;
import com.se.repository.CateroryRepository;
import com.se.service.CateroryService;


@Service
public class CateroryServiceImlp implements CateroryService {
	
	@Autowired
	private CateroryRepository cateroryRepository;

	@Override
	public List<Category> getAllCaterory() {
		// TODO Auto-generated method stub
		return cateroryRepository.findAll();
	}

	@Override
	public Category getCaterory(long theId) {
		// TODO Auto-generated method stub
		Optional<Category> result = cateroryRepository.findById(theId);
		Category category = null;
		if (result.isPresent()) {
			category = result.get();
		} else {
			throw new RuntimeException("Did not find caterory id="+ theId);
		}
		return category;
	}

	@Override
	public void saveCaterory(Category category) {
		// TODO Auto-generated method stub
		cateroryRepository.save(category);
		
	}

}
