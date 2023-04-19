package com.se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se.entity.Report;

@Repository
public interface ReportReponsitory extends JpaRepository<Report, Long> {

}
