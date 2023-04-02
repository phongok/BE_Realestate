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

import com.se.entity.NewsType;
import com.se.service.NewsTypeService;


@RequestMapping("/api")
@RestController
public class NewsTypeController {
	@Autowired
	private NewsTypeService newsTypeService;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("newsTypes")
	public Map<String, List<NewsType>> ListNewsType() {
		Map<String, List<NewsType>> map = new HashMap<>();
		map.put("data", newsTypeService.getAllNewsType());
		return map;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("newsTypesRent/listRent")
	public Map<String, List<NewsType>> ListNewsTypeRent() {
		Map<String, List<NewsType>> map = new HashMap<>();
		map.put("data", newsTypeService.getAllNewsTypeRent());
		return map;
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("newsTypes/{id}")
	public NewsType getNewsTypeById(long theId) {
		return newsTypeService.getNewsTypeById(theId);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("newsTypes")
	public NewsType createNewsType(@RequestBody NewsType newsType) {
		newsType.setAction(true);
		newsTypeService.saveNewsType(newsType);
		return newsType;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("newsTypes")
	public NewsType updateNewsType(@RequestBody NewsType newsType) {
		newsTypeService.saveNewsType(newsType);
		return newsType;
	}

}
