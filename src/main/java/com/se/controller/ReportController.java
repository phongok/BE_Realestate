package com.se.controller;

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

import com.se.entity.NewsType;
import com.se.entity.Report;
import com.se.entity.User;
import com.se.service.ReportService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	
	@PostMapping("reports")
	public Report createReport(@RequestBody Report report) {
		return reportService.saveReport(report);
	}
	
	@GetMapping("reports-paging")
	public Page<Report> getAllNewsPagePaging(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size, @RequestParam String userName) {
		 Pageable pageable = PageRequest.of(page, size);
		
		if (userName.equalsIgnoreCase("")==false) {
			return reportService.getReportSearch(userName, pageable);
		}
		
		 return reportService.getReport_Paging(pageable);
	}
	
	@GetMapping("findReportByID")
	public Report getReportById(@RequestParam long id) {
		System.out.println("id = "+id);
		return reportService.getReportById(id);
	}
	
	@PostMapping("stickreport")
	public Report StickReport(@RequestParam long reportid) {
		return reportService.StickReport(reportid);
	}
}
