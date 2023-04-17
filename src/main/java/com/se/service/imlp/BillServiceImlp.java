package com.se.service.imlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.entity.Bill;
import com.se.repository.BillRepository;
import com.se.service.BillService;

@Service
public class BillServiceImlp implements BillService {
	
	@Autowired
	private BillRepository billRepository;

	@Override
	public List<Bill> getAllBill() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveBill(Bill bill) {
		// TODO Auto-generated method stub
		billRepository.save(bill);
		
		
	}

}
