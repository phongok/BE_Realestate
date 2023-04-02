package com.se.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.se.entity.NewsType;
@Repository
public interface NewsTypeRepository extends JpaRepository<NewsType, Long>{
	
	@Query(value = "SELECT * FROM realestatedb.newstype where idcategory = 1", nativeQuery = true)
	public List<NewsType> getNewsTypeSell() ;
	@Query(value = "SELECT * FROM realestatedb.newstype where idcategory = 2", nativeQuery = true)
	public List<NewsType> getNewsTypeRent() ;

		
	
}
