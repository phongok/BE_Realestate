package com.se.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.se.entity.Report;
import com.se.repository.ReportReponsitory;
import com.se.service.ReportService;

@Service
public class ReportServiceImlp implements ReportService{

	@Autowired
	private ReportReponsitory reportReponsitory;
	
	@Override
	public Report saveReport(Report report) {
		// TODO Auto-generated method stub
		return reportReponsitory.save(report);
	}

	@Override
	public Page<Report> getReport_Paging(Pageable pageable) {
		// TODO Auto-generated method stub
		return reportReponsitory.getAllReport(pageable);
	}

	@Override
	public Report StickReport(long id) {
		// TODO Auto-generated method stub
		Report report = reportReponsitory.findById(id).get();
		report.setStatus("Đã xác nhận");
		reportReponsitory.save(report);
		return report;
		
	}

	@Override
	public Report getReportById(long id) {
		// TODO Auto-generated method stub
		Optional<Report> result = reportReponsitory.findById(id);
		Report report = null;
		if (result.isPresent()) {
			report = result.get();
		} else {
			throw new RuntimeException("Khong tim thay");
		}
		return report;
	}

	@Override
	public Page<Report> getReportSearch(String userName, Pageable pageable) {
		// TODO Auto-generated method stub
		return reportReponsitory.getReportSearch(userName, pageable);
	}

}
