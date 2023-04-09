package com.se.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.se.entity.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	public User findUserByUsername(String username);

	@Query(value = "select count(*) from realestatedb.user ", nativeQuery = true)
	public int getCountUser();

	@Query(value = "SELECT * FROM realestatedb.user WHERE name LIKE %?1% OR username LIKE %?1% OR phonenumber LIKE %?1% ", nativeQuery = true)
	public Page<User> findAll( String keyword , Pageable pageable);

}
