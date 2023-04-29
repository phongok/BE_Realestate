package com.se.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.RealEstate_Save;
import com.se.service.RealEstateSaveService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RealEstateSaveController {
	@Autowired
	private RealEstateSaveService realEstateSaveService;
	
	
	
	@PostMapping("realestatesaves")
	public RealEstate_Save createRealEstate_Save(@RequestBody RealEstate_Save realEstate_Save) {
		
		
		long idUserCheck = realEstate_Save.getUser().getId();
		long idRealEstateCheck = realEstate_Save.getRealEstate().getId();
		RealEstate_Save realEstate_Savetemp = realEstateSaveService.checkRealEstate(idUserCheck, idRealEstateCheck);
		System.out.println(realEstate_Savetemp);
//		realEstateSaveService.saveRealEstate(realEstate_Save);
		if (realEstate_Savetemp == null ) {
//			System.out.println("khac null");
			realEstateSaveService.saveRealEstate(realEstate_Save);
		}
		
		return realEstate_Save;
	}
	
	
	@GetMapping("realestatesaves/getlimit3")
	public List<RealEstate_Save> getRealEstateSaveLimit3(@RequestParam long iduser) {
		return realEstateSaveService.getRealEstate_Savelimit3(iduser);
	}
	@GetMapping("realestatesaves/forUser")
	public List<RealEstate_Save> getRealEstateSaveForUser(@RequestParam long iduser) {
		return realEstateSaveService.getRealEstate_SaveForUser(iduser);
	}
	@DeleteMapping("realestatesaves/{id}")
	public void Delete(@PathVariable long id) {
		realEstateSaveService.deleteById(id);
	}
}
