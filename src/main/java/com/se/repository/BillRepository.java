package com.se.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.se.entity.Bill;


@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
	
	@Query(value = "SELECT * FROM realestatedb.bill WHERE datepay BETWEEN :from AND :to", nativeQuery = true)
	public Page<Bill> getBillFromTo(@Param("from") Date from, @Param("to") Date to ,Pageable pageable);
	
	@Query(value = "SELECT SUM(totalmoney) AS total_sum FROM realestatedb.bill;", nativeQuery = true)
	public long getSumBILL();
	
	@Query(value = "SELECT sum(totalmoney)  from realestatedb.bill WHERE datepay BETWEEN :from AND :to", nativeQuery = true)
	public long getRevenueFromTo(@Param("from") Date from, @Param("to") Date to );
	
	@Query(value = "SELECT sum(totalmoney)  from realestatedb.bill WHERE month(datepay) =:month and year(datepay) =:year", nativeQuery = true)
	public String getRevenueChart(@Param("month") int month, @Param("year") int year );
	
	
	@Query(value = "select *from realestatedb.bill bill where bill.id_user = (select us.id from realestatedb.user us where us.username =:userName)", nativeQuery = true)
	public Page<Bill> getBillForUser(@Param("userName")String userName, Pageable pageable) ;
	

}
