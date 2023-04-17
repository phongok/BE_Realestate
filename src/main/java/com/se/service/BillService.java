package com.se.service;

import java.util.List;

import com.se.entity.Bill;

public interface BillService {
	public List<Bill> getAllBill () ;
	public void saveBill(Bill bill);
}
