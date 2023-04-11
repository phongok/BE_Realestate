package com.se.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Page<RealEstate> listHomeSell( @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size) {
		 Pageable pageable = PageRequest.of(page, size);
		return realEstateService.getHome_Sell(pageable);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("listrealestateRent")
	public Page<RealEstate> listHomeRent( @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size) {
		 Pageable pageable = PageRequest.of(page, size);
		return realEstateService.getHome_Rent(pageable);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("realestates/count")
	public String getAccountNumber() {
		return realEstateService.getRealEstateNumber()+"";
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("realestates-paging")
	public Page<RealEstate> getAllRealState_Paging(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
		 Pageable pageable = PageRequest.of(page, size);
		 return realEstateService.getAllRealState_Paging(pageable);
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("realestates-user/{id_user}")
	public Page<RealEstate> getRealStateBiIdUser(@PathVariable long id_user, @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size) {
		 Pageable pageable = PageRequest.of(page, size);
		return realEstateService.getRealStateBuUserID(id_user, pageable);
	}
	
}
