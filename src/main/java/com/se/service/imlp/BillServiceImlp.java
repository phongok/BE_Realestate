package com.se.service.imlp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Override
	public Page<Bill> getBillAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return billRepository.findAll(pageable);
	}

	@Override
	public Page<Bill> getBillFromTo(Date from, Date to, Pageable pageable) {
		// TODO Auto-generated method stub
		return billRepository.getBillFromTo(from, to, pageable);
	}

	@Override
	public String getrevenue() {
		// TODO Auto-generated method stub
		return billRepository.getSumBILL();
	}

}
