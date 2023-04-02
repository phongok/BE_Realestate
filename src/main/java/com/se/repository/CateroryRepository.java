package com.se.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.se.entity.Category;


@Repository
public interface CateroryRepository extends JpaRepository<Category, Long> {
	
	
	
	
	
		

}
