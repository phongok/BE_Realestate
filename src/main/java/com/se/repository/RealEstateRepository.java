package com.se.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.se.entity.RealEstate;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, Long> {

	@Query(value = "select * from realestatedb.realestate where id_category = 1 ", nativeQuery = true)
	public List<RealEstate> getHomeSell() ;
	
	@Query(value = "select * from realestatedb.realestate where id_category = 2", nativeQuery = true)
	public List<RealEstate> getHomeRent() ;
	
//	public int getCountRealeState();
}
