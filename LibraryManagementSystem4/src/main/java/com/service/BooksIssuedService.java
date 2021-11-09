package com.service;


import java.util.List;

import com.entities.BooksIssued;

public interface BooksIssuedService  {
	public BooksIssued addIssuedBook(BooksIssued issued);
	public BooksIssued updateIssuedBookDetails(BooksIssued booksIssued) throws Throwable;
	public List<BooksIssued> viewBooksIssuedList();
	List<BooksIssued> findByQuantitySorted(int quantity);
	BooksIssued findByIssueId(int issueId);
	public String deleteIssuedBooks(BooksIssued book) throws Throwable;

}