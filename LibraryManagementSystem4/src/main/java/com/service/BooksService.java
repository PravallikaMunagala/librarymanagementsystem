package com.service;

import java.util.List;

import com.entities.Books;

public interface BooksService {
	public Books addBook(Books book);
	public Books updateBookDetails(Books book) throws Throwable;
	public String removeBook(Books book);
	public List<Books> searchBookByTitle(String keyword);
	public List<Books> searchBookBySubject(String keyword);
	public List<Books> viewAllBooks();
}