package com.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.Bill;
import com.se.service.BillService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@PostMapping("bills")
	public Bill createBill(@RequestBody Bill bill) {
		 billService.saveBill(bill);
		 return bill;
	}

}
