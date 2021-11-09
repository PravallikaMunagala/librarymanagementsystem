package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Books;
import com.repository.AdminRepository;
import com.repository.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService{
@Autowired
private BooksRepository repo;
@Override
public Books addBook(Books book) {
	repo.save(book);
	return book;
}

@Override
public Books updateBookDetails(Books book)  throws Throwable {
    long bid = book.getBookid();
	//Supplier s1 = ()-> new BookNotFoundException("Book Does Not Exist in the Database");
	Books b1 = repo.findById(bid).orElseThrow();
	b1.setTitle(book.getTitle());
	b1.setSubject(book.getSubject());
	//b1.setAuthor(book.getAuthor());
	b1.setPublishedyear(book.getPublishedyear());
	b1.setPublishedyear(book.getPublishedyear());
	b1.setIsbncode(book.getIsbncode());
	b1.setQuantity(book.getQuantity());
	b1.setBookcost(book.getBookcost());
	b1.setShelfdetails(book.getShelfdetails());
	repo.save(b1);
	
	
	return b1;
}

@Override
public String removeBook(Books books) {
	repo.delete(books);
	return "Book Removed";
}

@Override
public List<Books> searchBookByTitle(String keyword) {
	List<Books> lb = repo.searchBookByTitle(keyword);
	return lb;
}

@Override
public List<Books> searchBookBySubject(String keyword) {
	 List<Books> lb1 = repo.searchBookBySubject(keyword);
		return lb1;
}

@Override
public List<Books> viewAllBooks() {
	List<Books> lb2 = repo.findAll();
	
	return lb2;
}

}