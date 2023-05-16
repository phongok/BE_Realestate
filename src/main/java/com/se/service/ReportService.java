package com.se.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.se.entity.Report;

public interface ReportService {
	public Report saveReport(Report report) ;
	public Page<Report> getReport_Paging(Pageable pageable);
	
	
	public Report StickReport(long id) ;
	
	public Report getReportById(long id) ;
	
	public Page<Report> getReportSearch(String userName, Pageable pageable) ;
	
}
