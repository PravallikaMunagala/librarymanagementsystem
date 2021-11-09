package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Books;

public interface BooksRepository extends JpaRepository<Books,Long>{

	List<Books> searchBookByTitle(String keyword);

	List<Books> searchBookBySubject(String keyword);

}