package com.se.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.NewsType;
import com.se.service.NewsTypeService;


@RequestMapping("/api")
@RestController
public class NewsTypeController {
	@Autowired
	private NewsTypeService newsTypeService;

	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("newsTypesSell/listSell")
	public  List<NewsType> ListNewsTypeSell() {
		return newsTypeService.getAllNewsTypeSell();
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("newsTypesRent/listRent")
	public  List<NewsType> ListNewsTypeRent() {
		return newsTypeService.getAllNewsTypeRent();
	}
	

	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("newsTypes/{id}")
	public NewsType getNewsTypeById(long theId) {
		return newsTypeService.getNewsTypeById(theId);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("newsTypes")
	public NewsType createNewsType(@RequestBody NewsType newsType) {
		newsType.setStatus("Đang hoạt động");
		newsTypeService.saveNewsType(newsType);
		return newsType;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("newsTypes")
	public NewsType updateNewsType(@RequestBody NewsType newsType) {
		newsTypeService.saveNewsType(newsType);
		return newsType;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("newsTypes/count")
	public String getNewsStateNumber() {
		return newsTypeService.getNewsTypeNumber()+"";
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("newsType-paging")
	public Page<NewsType> getAllNewsPagePaging(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size, @RequestParam String keyword) {
		 Pageable pageable = PageRequest.of(page, size);
		 Page<NewsType> pagenewstype = null;
		 if (keyword.equalsIgnoreCase("")==false) {
			pagenewstype = newsTypeService.getAllNewsPage_Paging(keyword, pageable);
		} else {
			pagenewstype =  newsTypeService.getAllNewsPage_Paging(pageable);
		}
		 return pagenewstype;
	}
}
