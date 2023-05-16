package com.se.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.se.entity.Bill;
import com.se.entity.Report;

@Repository
public interface ReportReponsitory extends JpaRepository<Report, Long> {
	
	@Query(value = "SELECT * FROM realestatedb.report rp where rp.accuser = (select us.id from realestatedb.user us where us.username =:userName) "
			+ "or rp.cheat = (select us.id from realestatedb.user us where us.username =:userName)" ,   nativeQuery = true)
	public Page<Report> getReportSearch(@Param("userName") String userName, Pageable pageable) ;
	
	@Query(value = "SELECT *\r\n"
			+ "FROM realestatedb.report\r\n"
			+ "ORDER BY  status ASC, date_report DESC", nativeQuery = true)
	public Page<Report> getAllReport( Pageable pageable) ;
		
}
