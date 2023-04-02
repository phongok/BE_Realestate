package com.se.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.RealEstate;
import com.se.service.RealEstateService;

@RestController
@RequestMapping("/api")
public class RealEstateController {
	@Autowired
	private RealEstateService realEstateService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("realestates")
	public RealEstate createHome(@RequestBody RealEstate home) {
		realEstateService.saveHome(home);
		return home;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("realestates")
	public RealEstate updateHome(@RequestBody RealEstate home) {
		realEstateService.saveHome(home);
		return home;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("realestates")
	public List<RealEstate> listHome() {
		return realEstateService.getAllHome();
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("realestates/{id}")
	public RealEstate getHomeById(@PathVariable long id) {
		
		return realEstateService.getHomeById(id);
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("realestates/{id}")
	public String deleteHome(@PathVariable long id) {
		RealEstate home = realEstateService.getHomeById(id);
		if (home==null) {
			throw new RuntimeException("Did not found home id = "+id);
		}
		realEstateService.deleteById(id);
		return "Delete home id = "+ id;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("listrealestateSell")
	public List<RealEstate> listHomeSell() {
		return realEstateService.getHome_Sell();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("listrealestateRent")
	public List<RealEstate> listHomeRent() {
		return realEstateService.getHome_Rent();
	}
	
}
