package com.se.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.BusinessType;
import com.se.service.imlp.BusinessTypeServiceImlp;

@RequestMapping("/api")
@RestController
public class BusinessTypeController {
	@Autowired
	private BusinessTypeServiceImlp typeServiceImlp;

	@GetMapping("businessTypes")
	public List<BusinessType> ListBusinessType() {
		return typeServiceImlp.getAllBusinessType();
	}

	@GetMapping("businessTypes/{id}")
	public BusinessType getBusinessById(long theId) {
		return typeServiceImlp.getBusinessTypeById(theId);
	}

	@PostMapping("businessTypes")
	public BusinessType createBusinessType(@RequestBody BusinessType businessType) {
		typeServiceImlp.saveBusinessType(businessType);
		return businessType;
	}
	
	@PutMapping("businessTypes")
	public BusinessType updateBusinessType(@RequestBody BusinessType businessType) {
		typeServiceImlp.saveBusinessType(businessType);
		return businessType;
	}

}
