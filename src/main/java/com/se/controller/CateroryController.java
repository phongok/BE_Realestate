package com.se.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.NewsType;
import com.se.entity.Category;
import com.se.service.CateroryService;

@RestController
@RequestMapping("/api")
public class CateroryController {
	@Autowired
	private CateroryService cateroryService;
	

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("caterorys")
	public  List<Category> listCaterory() {
		List<Category> categories = cateroryService.getAllCaterory();
		
		return categories;
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("caterorys")
	public Category createCaterory(@RequestBody Category category) {
		category.setStatus("Đang hoạt động");
		cateroryService.saveCaterory(category);
		return category;
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("caterorys")
	public Category updateCaterory(@RequestBody Category category) {
		cateroryService.saveCaterory(category);
		return category;
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("caterorys/{id}")
	public Category findOneCaterory(@PathVariable long theid) {
		Category category = cateroryService.getCaterory(theid);
		return category;
	}
	
	
	
}
