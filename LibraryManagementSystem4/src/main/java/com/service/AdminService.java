package com.service;

import java.util.List;

import com.entities.Admin;
import com.entities.Books;
import com.entities.BooksOrder;
import com.entities.DamagedBooks;
import com.entities.Users;

public interface AdminService {
	
	public Admin addAdminDetails(Admin ad);
	public Books addBooks(Books b);
	public Users validateUserDetails(Users user) throws Throwable;
	public Books updateBooks(Books books) throws Throwable;

	public Long removeBooks(Long bookid);

	public BooksOrder addBook(BooksOrder booksOrder);

	public BooksOrder updateBook(BooksOrder booksOrder) throws Throwable;

	public String removeBook(int orderId);

	public List<DamagedBooks> viewDamagedBooksList();

	public DamagedBooks viewDamagedBookById(int id)throws Throwable;
	public DamagedBooks addDamagedBooks( DamagedBooks  d);
	public List<Books> searchBookByTitle(String title);
	
	public List<Books> searchBookBySubject(String subject) ;
}