package com.se.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.se.entity.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

	@Query(value = "select * from realestate.home where id_category = 1 ", nativeQuery = true)
	public List<Home> getHomeSell() ;
	
	@Query(value = "select * from realestate.home where id_category = 2", nativeQuery = true)
	public List<Home> getHomeRent() ;
}
