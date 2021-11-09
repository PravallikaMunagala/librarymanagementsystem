package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.Readers;
@Repository
public interface ReadersRepository extends JpaRepository<Readers,Integer> {
	@Query("Select password from Readers password order by id.password")	
	Readers findByPassword(String password);
	
	@Query("Select mobileno from Readers mobileno order by id.mobileno")		
	Readers findByMobileno(String mobileno);
}