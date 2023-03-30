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

import com.se.entity.Home;
import com.se.service.HomeService;

@RestController
@RequestMapping("/api")
public class HomeController {
	@Autowired
	private HomeService homeService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("homes")
	public Home createHome(@RequestBody Home home) {
		
		UUID uuid = UUID.randomUUID();
		home.setId(uuid);
		homeService.saveHome(home);
		return home;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("homes")
	public Home updateHome(@RequestBody Home home) {
		homeService.saveHome(home);
		return home;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("homes")
	public List<Home> listHome() {
		return homeService.getAllHome();
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("homes/{id}")
	public Home getHomeById(@PathVariable UUID uuid) {
		return homeService.getHomeById(uuid);
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("homes/{id}")
	public String deleteHome(@PathVariable UUID uuid) {
		Home home = homeService.getHomeById(uuid);
		if (home==null) {
			throw new RuntimeException("Did not found home id = "+uuid);
		}
		
		homeService.deleteById(uuid);
		return "Delete home id = "+ uuid;
	}
}
