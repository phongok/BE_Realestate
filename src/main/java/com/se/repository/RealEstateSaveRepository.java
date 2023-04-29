package com.se.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.se.entity.RealEstate;
import com.se.entity.RealEstate_Save;


@Repository
public interface RealEstateSaveRepository extends JpaRepository<RealEstate_Save, Long>{
	
	@Query(value = "SELECT * FROM realestatedb.real_estate_save where id_user = :iduser and id_real_estate = :idRealestate", nativeQuery = true)
	public RealEstate_Save CheckRealEstate(@Param("iduser") long iduser, @Param("idRealestate") long idRealestate) ;
	
	
	@Query(value = "SELECT * FROM realestatedb.real_estate_save WHERE id_user = :iduser ORDER BY id DESC LIMIT 3;", nativeQuery = true)
	public List<RealEstate_Save> getRealEstateLimit3(@Param("iduser") long iduser) ;
	
	@Query(value = "SELECT * FROM realestatedb.real_estate_save WHERE id_user = :iduser ORDER BY id DESC ;", nativeQuery = true)
	public List<RealEstate_Save> getRealEstateForUser(@Param("iduser") long iduser) ;
		
	
}
