package com.se.controller;

import java.util.List;

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

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RealEstateController {
	@Autowired
	private RealEstateService realEstateService;

	@PostMapping("realestates")
	public RealEstate createHome(@RequestBody RealEstate home) {
		realEstateService.saveHome(home);
		return home;
	}
	
	

	@PutMapping("realestates")
	public RealEstate updateHome(@RequestBody RealEstate home) {
		realEstateService.saveHome(home);
		return home;
	}

	@GetMapping("realestates")
	public List<RealEstate> listHome() {
		return realEstateService.getAllHome();
	}

	@GetMapping("realestates/{id}")
	public RealEstate getHomeById(@PathVariable long id) {

		return realEstateService.getHomeById(id);

	}

	@DeleteMapping("realestates/{id}")
	public String deleteHome(@PathVariable long id) {
		RealEstate home = realEstateService.getHomeById(id);
		if (home == null) {
			throw new RuntimeException("Did not found home id = " + id);
		}
		realEstateService.deleteById(id);
		return "Delete home id = " + id;
	}

	
	@GetMapping("listrealestateSell")
	public Page<RealEstate> listHomeSell(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "1") int size, @RequestParam(defaultValue = "") String area,
			@RequestParam(defaultValue = "0") long priceMin, @RequestParam(defaultValue = "0") long priceMax,
			@RequestParam(defaultValue = "0") float acreageMin, @RequestParam(defaultValue = "0") float acreageMax) {
		Pageable pageable = PageRequest.of(page, size);
		Page<RealEstate> pageRealEstate = null;
		if (area.equalsIgnoreCase("") == false || priceMin>0 || priceMax >0 || acreageMin>0 || acreageMax>0) {
			
			if (priceMin==0 && priceMax == 0 && acreageMin==0 && acreageMax==0) {
				return realEstateService.getRealStateSellArea(area, pageable);
			}
			else if (area.equalsIgnoreCase("") && acreageMin==0 && acreageMax==0) {
				System.out.println("Thuc hien 1 minh price");
				return realEstateService.getRealStateSellPrice(priceMin, priceMax, pageable);
			}
			else if (area.equalsIgnoreCase("") && priceMin==0 && priceMax==0) {
				System.out.println(acreageMin);
				System.out.println(acreageMax);
				System.out.println("Thuc hien 1 minh acreage");
				return realEstateService.getRealStateSellAcreage(acreageMin, acreageMax, pageable);
			}
			else if (acreageMin==0 && acreageMax==0) {
				System.out.println("thuc hien price area");
				return realEstateService.getRealStateSellAreaPrice(area, priceMin, priceMax, pageable);
			}
			else if (priceMin == 0 && priceMax==0) {
				System.out.println("thuc hien acreage area");
				return realEstateService.getRealStateSellAreaAcreage(area, acreageMin, acreageMax, pageable);
				
			}
			else if (area.equalsIgnoreCase("")==true) {
				System.out.println("thuc hien acreage price");
				return realEstateService.getRealStateSellPriceAcreage(priceMin, priceMax, acreageMin, acreageMax, pageable);
			}
			else if (area.equalsIgnoreCase("") == false && priceMin>0 && priceMax >0 && acreageMin>0 && acreageMax>0) {
				return realEstateService.getRealStateSellAreaPriceAcreage(area, priceMin, priceMax, acreageMin, acreageMax, pageable);
			}
			
		}
		
		
		
		System.out.println("thuc hien tong");
		return realEstateService.getHome_Sell(pageable);
	}

	@GetMapping("listrealestateRent")
	public Page<RealEstate> listHomeRent(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "1") int size, @RequestParam(defaultValue = "") String area,
			@RequestParam(defaultValue = "0") long priceMin, @RequestParam(defaultValue = "0") long priceMax,
			@RequestParam(defaultValue = "0") float acreageMin, @RequestParam(defaultValue = "0") float acreageMax) {
		Pageable pageable = PageRequest.of(page, size);
		Page<RealEstate> pageRealEstate = null;
		if (area.equalsIgnoreCase("") == false || priceMin>0 || priceMax >0 || acreageMin>0 || acreageMax>0) {
			
			if (priceMin==0 && priceMax == 0 && acreageMin==0 && acreageMax==0) {
				return realEstateService.getRealStateRentArea(area, pageable);
			}
			else if (area.equalsIgnoreCase("") && acreageMin==0 && acreageMax==0) {
				System.out.println("Thuc hien 1 minh price");
				return realEstateService.getRealStateRentPrice(priceMin, priceMax, pageable);
			}
			else if (area.equalsIgnoreCase("") && priceMin==0 && priceMax==0) {
				System.out.println(acreageMin);
				System.out.println(acreageMax);
				System.out.println("Thuc hien 1 minh acreage");
				return realEstateService.getRealStateRentAcreage(acreageMin, acreageMax, pageable);
			}
			else if (acreageMin==0 && acreageMax==0) {
				System.out.println("thuc hien price area");
				return realEstateService.getRealStateRentAreaPrice(area, priceMin, priceMax, pageable);
			}
			else if (priceMin == 0 && priceMax==0) {
				System.out.println("thuc hien acreage area");
				return realEstateService.getRealStateRentAreaAcreage(area, acreageMin, acreageMax, pageable);
				
			}
			else if (area.equalsIgnoreCase("")==true) {
				System.out.println("thuc hien acreage price");
				return realEstateService.getRealStateRentPriceAcreage(priceMin, priceMax, acreageMin, acreageMax, pageable);
			}
			else if (area.equalsIgnoreCase("") == false && priceMin>0 && priceMax >0 && acreageMin>0 && acreageMax>0) {
				return realEstateService.getRealStateRentAreaPriceAcreage(area, priceMin, priceMax, acreageMin, acreageMax, pageable);
			}
			
		}
		
		
		
		System.out.println("thuc hien tong");
		return realEstateService.getHome_Rent(pageable);
	}

	

	@GetMapping("realestates-newstype/{id_newstype}")
	public Page<RealEstate> getRealStateByIdNewsType(@PathVariable long id_newstype, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "1") int size, @RequestParam(defaultValue = "") String area,
			@RequestParam(defaultValue = "0") long priceMin, @RequestParam(defaultValue = "0") long priceMax,
			@RequestParam(defaultValue = "0") float acreageMin, @RequestParam(defaultValue = "0") float acreageMax) {
		
		Pageable pageable = PageRequest.of(page, size);
		Page<RealEstate> pageRealEstate = null;
		if (area.equalsIgnoreCase("") == false || priceMin>0 || priceMax >0 || acreageMin>0 || acreageMax>0) {
			
			if (priceMin==0 && priceMax == 0 && acreageMin==0 && acreageMax==0) {
				return realEstateService.getRealStateNewsTypeArea(id_newstype, area, pageable);
			}
			else if (area.equalsIgnoreCase("") && acreageMin==0 && acreageMax==0) {
				System.out.println("Thuc hien 1 minh price");
				return realEstateService.getRealStateNewsTypePrice(id_newstype,priceMin, priceMax, pageable);
			}
			else if (area.equalsIgnoreCase("") && priceMin==0 && priceMax==0) {
				System.out.println(acreageMin);
				System.out.println(acreageMax);
				System.out.println("Thuc hien 1 minh acreage");
				return realEstateService.getRealStateNewsTypeAcreage(id_newstype, acreageMin, acreageMax, pageable);
			}
			else if (acreageMin==0 && acreageMax==0) {
				System.out.println("thuc hien price area");
				return realEstateService.getRealStateNewsTypeAreaPrice(id_newstype, area, priceMin, priceMax, pageable);
			}
			else if (priceMin == 0 && priceMax==0) {
				System.out.println("thuc hien acreage area");
				return realEstateService.getRealStateNewsTypeAreaAcreage(id_newstype, area, acreageMin, acreageMax, pageable);
				
			}
			else if (area.equalsIgnoreCase("")==true) {
				System.out.println("thuc hien acreage price");
				return realEstateService.getRealStateNewsTypePriceAcreage(id_newstype, priceMin, priceMax, acreageMin, acreageMax, pageable);
			}
			else if (area.equalsIgnoreCase("") == false && priceMin>0 && priceMax >0 && acreageMin>0 && acreageMax>0) {
				return realEstateService.getRealStateNewsTypeAreaPriceAcreage(id_newstype,area, priceMin, priceMax, acreageMin, acreageMax, pageable);
			}
			
		}
		
		
		
		System.out.println("thuc hien tong");
		return realEstateService.getRealStateByNewsTypeID(id_newstype, pageable);
	}

	@GetMapping("realestates/count")
	public String getAccountNumber() {
		return realEstateService.getRealEstateNumber() + "";
	}

	@GetMapping("realestates-paging")
	public Page<RealEstate> getAllRealState_Paging(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "0") long idNewsType, @RequestParam(defaultValue = "") String username  ) {
		Pageable pageable = PageRequest.of(page, size);
		Page<RealEstate> pageRealEstate = null;
		if (idNewsType>0 || username.equalsIgnoreCase("") == false ) {
			if (idNewsType>0) {
				return realEstateService.getAllByNewsTypeAdmin(idNewsType, pageable);
			}
			else if (username.equalsIgnoreCase("") == false) {
				return realEstateService.getAllByUserNameAdmin(username, pageable);
			}
			else if (idNewsType>0 && username.equalsIgnoreCase("") == false) {
				return realEstateService.getAllByNewsTypeUserNameAdmin(idNewsType, username, pageable);
			}
		}
		return realEstateService.getAllRealState_Paging(pageable);
	}
	
	@GetMapping("realestates-paging-user")
	public Page<RealEstate> getAllRealState_Paging_User(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "0") long idNewsType,  @RequestParam(defaultValue = "0") long idUser  ) {
		Pageable pageable = PageRequest.of(page, size);
		Page<RealEstate> pageRealEstate = null;
		if (idNewsType>0) {
		 return	realEstateService.getAllByNewsTypeUser(idNewsType, idUser, pageable);
		}
		return realEstateService.getAllByUser(idUser, pageable);
	}

	@GetMapping("realestates-user/{id_user}")
	public Page<RealEstate> getRealStateByIdUser(@PathVariable long id_user, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "12") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return realEstateService.getRealStateByUserID(id_user, pageable);
	}
	
	@GetMapping("outstanding")
	public List<RealEstate> getRealStateoutstanding(
			) {
		
		return realEstateService.getRe20();
	}
	
	
	@PutMapping("realestate/delete")
	public RealEstate deleteRealEstate(@RequestParam long idre) {
		return realEstateService.deleteRealEstate(idre);
	}
}
