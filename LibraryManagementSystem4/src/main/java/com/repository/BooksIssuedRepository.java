package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.BooksIssued;

@Repository
public interface BooksIssuedRepository extends JpaRepository<BooksIssued,Integer> 
{
	BooksIssued findByIssueId(int issueId);
	
	@Query("Select bookissued from BooksIssued bookissued order by bookissued.issueId")
	List<BooksIssued> findByQuantitySorted(int quantity);
}