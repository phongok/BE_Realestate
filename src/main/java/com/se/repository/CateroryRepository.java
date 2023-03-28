package com.se.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.se.entity.Category;
import com.se.entity.Home;

@Repository
public interface CateroryRepository extends JpaRepository<Category, Long> {
	
	
	
	
	
		

}
