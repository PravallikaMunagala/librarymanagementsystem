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

import com.entities.Author;
import com.repository.AuthorRepository;
@SpringBootTest
class AuthorServiceImplTest {
	@Autowired
	AuthorService authorservice;
	
	@MockBean
	AuthorRepository authorrepo;
	
	@Test
	void testAddAuthorDetails() {
		Author aut = new Author();
		aut.setAuthorId(1);
		aut.setFirstName("Asha");
		aut.setLastName("Munagala");
		aut.setContactno("8465303236");
		aut.setEmail("asha26@gmail.com");
		Mockito.when(authorrepo.save(aut)).thenReturn(aut);
		assertThat(authorservice.addAuthorDetails(aut)).isEqualTo(aut);
	}

	@Test
	void testUpdateAuthorDetails() throws Throwable {
		Author aut = new Author();
		aut.setAuthorId(1);
		aut.setFirstName("Asha");
		aut.setLastName("Munagala");
		aut.setContactno("8465303236");
		aut.setEmail("asha26@gmail.com");
		Optional<Author> aut2 =  Optional.of(aut);
		Mockito.when(authorrepo.findById(1)).thenReturn(aut2);
		Mockito.when(authorrepo.save(aut)).thenReturn(aut);
		aut.setFirstName("Lakshmi");
		aut.setLastName("Reddy");
		aut.setContactno("9848293951");
		aut.setEmail("lakshmireddy@gmail.com");
	
		assertThat(authorservice.updateAuthorDetails(aut)).isEqualTo(aut);
	}

	@Test
	void testDeleteAuthorDetails() {
		Author aut = new Author();
		aut.setAuthorId(1);
		aut.setFirstName("Asha");
		aut.setLastName("Munagala");
		aut.setContactno("8465303236");
		aut.setEmail("asha26a@gmail.com");
		Optional<Author> c2=Optional.of(aut);
		Mockito.when(authorrepo.findById(1)).thenReturn(c2);
		Mockito.when(authorrepo.existsById(aut.getAuthorId())).thenReturn(false);
		assertFalse(authorrepo.existsById(aut.getAuthorId()));
	}

	@Test
	void testViewAuthorsList() {
		Author aut = new Author();
		aut.setAuthorId(1);
		aut.setFirstName("Asha");
		aut.setLastName("Munagala");
		aut.setContactno("8465303236");
		aut.setEmail("asha26@gmail.com");
		
		Author aut1 = new Author();
		aut1.setAuthorId(1);
		aut1.setFirstName("Lakshmi");
		aut1.setLastName("Reddy");
		aut1.setContactno("9848293951");
		aut1.setEmail("lakshmireddy@gmail.com");
		
		List<Author> authorList = new ArrayList<Author>();
		authorList.add(aut);
		authorList.add(aut1);
		
		Mockito.when(authorrepo.findAll()).thenReturn(authorList);
		assertThat(authorservice.viewAuthorsList()).isEqualTo(authorList);
	}

	@Test
	void testViewAuthorById() throws Throwable {
		Author aut = new Author();
		aut.setAuthorId(1);
		aut.setFirstName("Asha");
		aut.setLastName("Munagala");
		aut.setContactno("8465303236");
		aut.setEmail("asha26@gmail.com");
	
		Optional<Author> c2 = Optional.of(aut);
		Mockito.when(authorrepo.findById(1)).thenReturn(c2);
		assertThat(authorservice.viewAuthorById(1)).isEqualTo(aut);
	}

	@Test
	void testGetAuthorByFirstName() throws Throwable {
		 Author a1=new Author();
		    a1.setAuthorId(1);
			a1.setFirstName("Asha");
			a1.setLastName("Munagala");
			a1.setContactno("8465303236");
			a1.setEmail("asha26@gmail.com");
			Optional<Author> a2 = Optional.of(a1);
			Mockito.when(authorrepo.findByFirstName("Asha")).thenReturn(a1);
			assertThat(authorservice.getAuthorByFirstName("Asha")).isEqualTo(a1);
	}

	@Test
	void testGetByEmail() throws Throwable {
		 Author a1=new Author();
		    a1.setAuthorId(1);
			a1.setFirstName("Asha");
			a1.setLastName("Munagala");
			a1.setContactno("8465303236");
			a1.setEmail("asha26@gmail.com");
			Optional<Author> a2 = Optional.of(a1);
			Mockito.when(authorrepo.findByFirstName("Asha")).thenReturn(a1);
			assertThat(authorservice.getAuthorByFirstName("Asha")).isEqualTo(a1);
	}

}