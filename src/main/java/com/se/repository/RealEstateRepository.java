package com.se.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.se.entity.RealEstate;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, Long> {

	@Query(value = "select * from realestatedb.realestate where id_category = 1 ", nativeQuery = true)
	public Page<RealEstate> getHomeSell(Pageable pageable) ;
	
	@Query(value = "select * from realestatedb.realestate where id_category = 2", nativeQuery = true)
	public Page<RealEstate> getHomeRent(Pageable pageable) ;
	
	@Query(value = "select count(*) from realestatedb.realestate", nativeQuery = true)
	public int getCountRealeState();
	
	
	@Query(value = "SELECT * FROM realestatedb.realestate where id_user = ?1", nativeQuery = true)
	public Page<RealEstate> getRealStateByUserId(long idUser, Pageable pageable);
	
	
	@Query(value = "SELECT * FROM realestatedb.realestate where id_news_type = ?1 and status = 'Đang hoạt động'", nativeQuery = true)
	public Page<RealEstate> getRealStateByNewsTypeID(long idNews, Pageable pageable);
}
