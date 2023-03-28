package com.se.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.se.entity.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, UUID> {

	@Query(value = "select * from realestate.home where id_category = 1 and id_user = :id_user", nativeQuery = true)
	public List<Home> getHomeSellbyIdUser(@Param("id_user") Integer id_user) ;
	
	@Query(value = "select * from realestate.home where id_category = 2 and id_user = :id_user", nativeQuery = true)
	public List<Home> getHomeRentbyIdUser(@Param("id_user") Integer id_user) ;
}
