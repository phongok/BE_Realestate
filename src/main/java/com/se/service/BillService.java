package com.se.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.se.entity.Bill;

public interface BillService {
	public List<Bill> getAllBill () ;
	public void saveBill(Bill bill);
	
	public Page<Bill> getBillAll(Pageable pageable);
	public Page<Bill> getBillFromTo(Date from, Date to, Pageable pageable );
	
	public Page<Bill> getBillForUser(String userName, Pageable pageable );
	
	public long getrevenue() ;
	
	public long getRevenueFromTo(Date from, Date to);
	
	public List<Double> getRevenueMonth();
}
