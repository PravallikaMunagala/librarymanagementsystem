package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.BooksReturned;
import com.repository.BooksReturnedRepository;
@SpringBootTest
class BooksReturnedServiceImplTest {
	@Autowired
	BooksReturnedService bookreturnservice;
	@MockBean
	BooksReturnedRepository booksreturnrepo;
	@Test
	void testReturnBooks() {
        BooksReturned br = new BooksReturned();
	    br.setId(1);
		br.setReturnedDate(null);
		br.setPenalty(0);
		br.setPenaltyStatus("nill");
		br.setDelayedDays(0);
		Mockito.when(booksreturnrepo.save(br)).thenReturn(br);
		assertThat(bookreturnservice.returnBooks(br)).isEqualTo(br);
	}

	@Test
	void testUpdateReturnedBookDetails() throws Throwable {
		BooksReturned br = new BooksReturned();
	    br.setId(1);
	    br.setReturnedDate(null);
	    br.setDelayedDays(0);
	    br.setPenalty(0);
	    br.setPenaltyStatus("nill");
	    Optional<BooksReturned> c2 =  Optional.of(br);
		Mockito.when(booksreturnrepo.findById(1)).thenReturn(c2);
		Mockito.when(booksreturnrepo.save(br)).thenReturn(br);
	    br.setReturnedDate(null);
	    br.setDelayedDays(2);
	    br.setPenalty(10);
	    br.setPenaltyStatus("paid");
		assertThat(bookreturnservice.updateReturnedBookDetails(br)).isEqualTo(br);
	}

	@Test
	void testViewReturnedBooksList() {
		BooksReturned br = new BooksReturned();
		br.setId(1);
	  	br.setReturnedDate(null);
		br.setPenalty(0);
		br.setPenaltyStatus("nill");
		br.setDelayedDays(0);
			
	    BooksReturned br1 = new BooksReturned();	
		br1.setId(1);
		br1.setReturnedDate(null);
		br1.setPenalty(0);
		br1.setPenaltyStatus("nill");
		br1.setDelayedDays(0);
		List<BooksReturned> bookList = new ArrayList<BooksReturned>();
		bookList.add(br);
		bookList.add(br1);
			
		Mockito.when(booksreturnrepo.findAll()).thenReturn(bookList);
		assertThat(bookreturnservice.viewReturnedBooksList()).isEqualTo(bookList);
	}

	@Test
	void testViewDelayedBooksList() {
		BooksReturned br = new BooksReturned();
		br.setId(1);
		br.setReturnedDate(null);
		br.setPenalty(10);
		br.setPenaltyStatus("paid");
		br.setDelayedDays(2);
		
        BooksReturned br1 = new BooksReturned();
		br1.setId(1);
		br1.setReturnedDate(null);
		br1.setPenalty(15);
		br1.setPenaltyStatus(null);
		br1.setDelayedDays(3);
		List<BooksReturned> bookList = new ArrayList<BooksReturned>();
		bookList.add(br);
		bookList.add(br1);
		
		Mockito.when(booksreturnrepo.findAll()).thenReturn(bookList);
		assertThat(bookreturnservice.viewDelayedBooksList()).isEqualTo(bookList);
	}

}