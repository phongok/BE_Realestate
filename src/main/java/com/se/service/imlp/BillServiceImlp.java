package com.se.service.imlp;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
	public long getrevenue() {
		// TODO Auto-generated method stub
		return billRepository.getSumBILL();
	}

	@Override
	public long getRevenueFromTo(Date from, Date to) {
		// TODO Auto-generated method stub
		return billRepository.getRevenueFromTo(from, to);
	}
	
	@Override
	public Page<Bill> getBillForUser(String userName, Pageable pageable) {
		// TODO Auto-generated method stub
		return billRepository.getBillForUser(userName, pageable);
	}

	@Override
	public List<Double> getRevenueMonth() {
		// TODO Auto-generated method stub
		Date dateSearch =  new Date();
		List<Double> listData =  new ArrayList<>();
		
		String thang1  = billRepository.getRevenueChart(1, 2023);
		double month1  = 0;
		if (thang1 == null) {
			System.out.println("Thuc hien");
			month1 = 0;
		} else {
			 month1 = Long.parseLong(thang1);
		}
		
		
		String thang2  = billRepository.getRevenueChart(2, 2023);
		double month2  = 0;
		if (thang2 == null) {
			month2 = 0;
		} else {
			 month2 = Long.parseLong(thang2);
		}
		String thang3  = billRepository.getRevenueChart(3, 2023);
		double month3  = 0;
		if (thang3 == null) {
			month3 = 0;
		} else {
			 month3 = Double.parseDouble(thang3);
		}
		String thang4  = billRepository.getRevenueChart(4, 2023);
		double month4  = 0;
		if (thang4 == null) {
			month4 = 0;
		} else {
			 month4 = Double.parseDouble(thang4);
		}
		String thang5  = billRepository.getRevenueChart(5, 2023);
		double month5  = 0;
		if (thang5 == null) {
			month5 = 0;
		} else {
			
			 month5 = Double.parseDouble(thang5);
		}
		String thang6  = billRepository.getRevenueChart(6, 2023);
		double month6  = 0;
		if (thang6 == null) {
			month6 = 0;
		} else {
			 month6 = Double.parseDouble(thang6);
		}
		String thang7  = billRepository.getRevenueChart(7, 2023);
		double month7  = 0;
		if (thang7 == null) {
			month7 = 0;
		} else {
			 month7 = Double.parseDouble(thang7);
		}
		String thang8  = billRepository.getRevenueChart(8, 2023);
		double month8  = 0;
		if (thang8 == null) {
			month8 = 0;
		} else {
			 month8 = Double.parseDouble(thang8);
		}
		String thang9  = billRepository.getRevenueChart(1, 2023);
		double month9  = 0;
		if (thang9 == null) {
			month9 = 0;
		} else {
			 month9 = Double.parseDouble(thang9);
		}
		String thang10  = billRepository.getRevenueChart(10, 2023);
		double month10  = 0;
		if (thang10 == null) {
			month10 = 0;
		} else {
			 month10 = Double.parseDouble(thang10);
		}
		String thang11  = billRepository.getRevenueChart(11, 2023);
		double month11  = 0;
		if (thang11 == null) {
			month11 = 0;
		} else {
			 month11 = Double.parseDouble(thang11);
		}
		
		String thang12  = billRepository.getRevenueChart(12, 2023);
		double month12  = 0;
		if (thang12 == null) {
			month12 = 0;
		} else {
			 month12 = Double.parseDouble(thang12);
		}
		
		listData.add(month1);
		listData.add(month2);
		listData.add(month3);
		listData.add(month4);
		listData.add(month5);
		listData.add(month6);
		listData.add(month7);
		listData.add(month8);
		listData.add(month9);
		listData.add(month10);
		listData.add(month11);
		listData.add(month12);
		
		return listData;
	}

	

}
