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

	@Query(value = "select * from realestatedb.realestate where id_category = 1 and status = 'Đang hoạt động'", nativeQuery = true)
	public Page<RealEstate> getHomeSell(Pageable pageable);

	@Query(value = "select * from realestatedb.realestate where id_category = 2 and status = 'Đang hoạt động'", nativeQuery = true)
	public Page<RealEstate> getHomeRent(Pageable pageable);

	@Query(value = "select count(*) from realestatedb.realestate", nativeQuery = true)
	public int getCountRealeState();

	@Query(value = "SELECT * FROM realestatedb.realestate where id_user = ?1 and status = 'Đang hoạt động'", nativeQuery = true)
	public Page<RealEstate> getRealStateByUserId(long idUser, Pageable pageable);

	@Query(value = "SELECT * FROM realestatedb.realestate where id_news_type = ?1 and status = 'Đang hoạt động'", nativeQuery = true)
	public Page<RealEstate> getRealStateByNewsTypeID(long idNews, Pageable pageable);

	
	/////
	
	
	@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 2  and status=\"Đang hoạt động\" and area = ?1 and price>= ?2 and price<= ?3 and acreage >= ?4 and acreage <= ?5;", nativeQuery = true)
	public Page<RealEstate> getRentFTArea(String area ,long priceMin, long priceMax, float acreageMin, float acreageMax , Pageable pageable);
	
	@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 2  and status=\"Đang hoạt động\" and price>= ?2 and price<= ?3 and acreage >= ?4 and acreage <= ?5;", nativeQuery = true)
	public Page<RealEstate> getRentFTNonArea(String area ,long priceMin, long priceMax, float acreageMin, float acreageMax , Pageable pageable);
	
	///
	
	@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 2  and status=\"Đang hoạt động\" and area = ?1 ", nativeQuery = true)
	public Page<RealEstate> getRentFTArea(String area, Pageable pageable ); ///ok
	
	@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 2  and status=\"Đang hoạt động\" and price>= ?1 and price<= ?2 ", nativeQuery = true)
	public Page<RealEstate> getRentFTPrice(long priceMin, long priceMax, Pageable pageable ); 
	
	
	@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 2  and status=\"Đang hoạt động\" and acreage >= :acreageMin and acreage <= :acreageMax", nativeQuery = true)
	public Page<RealEstate> getRentFTAcreage(@Param("acreageMin") float acreageMin,@Param("acreageMax") float acreageMax, Pageable pageable );
	
	///
	
	
}
