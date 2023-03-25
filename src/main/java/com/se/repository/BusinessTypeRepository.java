package com.se.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.se.entity.BusinessType;
@Repository
public interface BusinessTypeRepository extends JpaRepository<BusinessType, Long>{
	
	@Query(value = "SELECT * FROM realestate.business_type where idcategory = 1", nativeQuery = true)
	public List<BusinessType> getBusinessTypeSell() ;
	@Query(value = "SELECT * FROM realestate.business_type where idcategory = 2", nativeQuery = true)
	public List<BusinessType> getBusinessTypeRent() ;
	@Query(value = "SELECT * FROM realestate.business_type where idcategory = 3", nativeQuery = true)
	public List<BusinessType> getBusinessTypeProtect() ;
		
	
}
