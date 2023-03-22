package com.se.service;

import java.util.List;

import com.se.entity.BusinessType;

public interface BusinessTypeService {
	public List<BusinessType> getAllBusinessType();
	public BusinessType getBusinessTypeById(long theId) ;
	public void saveBusinessType(BusinessType typeofsale);
}
