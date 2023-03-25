package com.se.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.entity.BusinessType;
import com.se.repository.BusinessTypeRepository;
import com.se.service.BusinessTypeService;

@Service
public class BusinessTypeServiceImlp implements BusinessTypeService{

	@Autowired
	private BusinessTypeRepository typeofsaleRepository;
	
	@Override
	public List<BusinessType> getAllBusinessType() {
		// TODO Auto-generated method stub
		return typeofsaleRepository.findAll();
	}

	@Override
	public BusinessType getBusinessTypeById(long theId) {
		// TODO Auto-generated method stub
		Optional<BusinessType> result = typeofsaleRepository.findById(theId);
		BusinessType typeofsale = null;
		if (result.isPresent()) {
			typeofsale = result.get();
		} else {
			throw new RuntimeException("Did not find BusinessType id="+ theId);
		}
		return typeofsale;
	}

	@Override
	public void saveBusinessType(BusinessType typeofsale) {
		// TODO Auto-generated method stub
		typeofsaleRepository.save(typeofsale);
		
	}

	@Override
	public List<BusinessType> getAllBusinessTypeSell() {
		// TODO Auto-generated method stub
		return typeofsaleRepository.getBusinessTypeSell();
	}

	@Override
	public List<BusinessType> getAllBusinessTypeRent() {
		// TODO Auto-generated method stub
		return typeofsaleRepository.getBusinessTypeRent();
	}

	@Override
	public List<BusinessType> getAllBusinessTypeProtect() {
		// TODO Auto-generated method stub
		return typeofsaleRepository.getBusinessTypeProtect();
	}

}
