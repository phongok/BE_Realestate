package com.se.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.entity.NewsType;
import com.se.repository.NewsTypeRepository;
import com.se.service.NewsTypeService;

@Service
public class NewsTypeServiceImlp implements NewsTypeService{

	@Autowired
	private NewsTypeRepository newsTypeRepository;
	
	@Override
	public List<NewsType> getAllNewsType() {
		// TODO Auto-generated method stub
		return newsTypeRepository.findAll();
	}

	@Override
	public NewsType getNewsTypeById(long theId) {
		// TODO Auto-generated method stub
		Optional<NewsType> result = newsTypeRepository.findById(theId);
		NewsType typeofsale = null;
		if (result.isPresent()) {
			typeofsale = result.get();
		} else {
			throw new RuntimeException("Did not find BusinessType id="+ theId);
		}
		return typeofsale;
	}

	@Override
	public void saveNewsType(NewsType typeofsale) {
		// TODO Auto-generated method stub
		newsTypeRepository.save(typeofsale);
		
	}

	@Override
	public List<NewsType> getAllNewsTypeSell() {
		// TODO Auto-generated method stub
		return newsTypeRepository.getNewsTypeRent();
	}

	@Override
	public List<NewsType> getAllNewsTypeRent() {
		// TODO Auto-generated method stub
		return newsTypeRepository.getNewsTypeRent();
	}

	@Override
	public int getNewsTypeNumber() {
		// TODO Auto-generated method stub
		return newsTypeRepository.getCountNewsType();
	}

	

}
