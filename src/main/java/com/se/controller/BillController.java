package com.se.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.Bill;
import com.se.entity.User;
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
	
	@GetMapping("bills-paging")
	public Page<Bill> getBillPageing(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size, @RequestParam String from, @RequestParam String to, @RequestParam String userName) {
		
		 Pageable pageable = PageRequest.of(page, size);
		 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 
		 Date fromDate = null;
		try {
			fromDate = formatter.parse(from);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Date toDate = null;
		try {
			toDate = formatter.parse(to);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 if (userName.equalsIgnoreCase("") == false) {
			return billService.getBillForUser(userName, pageable);
		}
		 else if (from.equalsIgnoreCase("") ==false || to.equalsIgnoreCase("") ==false) {
				return billService.getBillFromTo(fromDate, toDate, pageable);
			}
		 
		 return billService.getBillAll(pageable); 
	}
	
	
	@GetMapping("getRevenue")
	public long getRevenue() {
		return billService.getrevenue();
	}
	
	@GetMapping("getRevenueFromTo")
	public long getRevenueFromTo(
             @RequestParam String from, @RequestParam String to) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 
		 Date fromDate = null;
		try {
			fromDate = formatter.parse(from);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Date toDate = null;
		try {
			toDate = formatter.parse(to);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return billService.getRevenueFromTo(fromDate, toDate);
	}
	@GetMapping("getRevenueMonthChart")
	List<Double> getRevenueMonth() {
		return billService.getRevenueMonth();
	}


}
