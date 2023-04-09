package com.se.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.se.entity.NewsType;
@Repository
public interface NewsTypeRepository extends PagingAndSortingRepository<NewsType, Long>{
	
	@Query(value = "SELECT * FROM realestatedb.newstype where idcategory = 1", nativeQuery = true)
	public List<NewsType> getNewsTypeSell() ;
	
	@Query(value = "SELECT * FROM realestatedb.newstype where idcategory = 2", nativeQuery = true)
	public List<NewsType> getNewsTypeRent() ;

	@Query(value = "select count(*) from realestatedb.news_type", nativeQuery = true)
	public int getCountNewsType();
	
	@Query(value = "SELECT * FROM realestatedb.news_type WHERE name LIKE %?1%", nativeQuery = true)
	public Page<NewsType> findAll(String keyword , Pageable pageable);
	
}
