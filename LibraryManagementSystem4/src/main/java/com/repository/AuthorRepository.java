package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> 
{
	//@Query("select Authors from Author Authors order by Authors.firstName")
   Author findByFirstName(String firstName) ;
   
   @Query("select Authors from Author Authors order by Authors.email")
   List<Author> findByEmailSorted(String email);
}