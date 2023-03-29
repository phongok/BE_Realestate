package com.se.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.BusinessType;
import com.se.service.BusinessTypeService;


@RequestMapping("/api")
@RestController
public class BusinessTypeController {
	@Autowired
	private BusinessTypeService businessTypeService;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("businessTypes")
	public Map<String, List<BusinessType>> ListBusinessType() {
		Map<String, List<BusinessType>> map = new HashMap<>();
		map.put("data", businessTypeService.getAllBusinessType());
		return map;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("businessTypes/listSell")
	public Map<String, List<BusinessType>> ListBusinessTypeSell() {
		Map<String, List<BusinessType>> map = new HashMap<>();
		map.put("data", businessTypeService.getAllBusinessTypeSell());
		return map;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("businessTypesRent/listRent")
	public Map<String, List<BusinessType>> ListBusinessTypeRent() {
		Map<String, List<BusinessType>> map = new HashMap<>();
		map.put("data", businessTypeService.getAllBusinessTypeRent());
		return map;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("businessTypes/listProtect")
	public Map<String, List<BusinessType>> ListBusinessTypeProtect() {
		Map<String, List<BusinessType>> map = new HashMap<>();
		map.put("data", businessTypeService.getAllBusinessTypeProtect());
		return map;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("businessTypes/{id}")
	public BusinessType getBusinessById(long theId) {
		return businessTypeService.getBusinessTypeById(theId);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("businessTypes")
	public BusinessType createBusinessType(@RequestBody BusinessType businessType) {
		businessType.setAction(true);
		businessTypeService.saveBusinessType(businessType);
		return businessType;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("businessTypes")
	public BusinessType updateBusinessType(@RequestBody BusinessType businessType) {
		businessTypeService.saveBusinessType(businessType);
		return businessType;
	}

}