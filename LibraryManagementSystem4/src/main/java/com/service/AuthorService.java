package com.service;

import java.util.List;
import com.advices.AuthorNotFoundException;
import com.entities.Author;

public interface AuthorService {
	public Author addAuthorDetails(Author author);
	public Author updateAuthorDetails(Author author) throws Throwable;
	public String deleteAuthorDetails(Author author);
	public List<Author> viewAuthorsList();
	public Author viewAuthorById(int authorId) throws Throwable;
	public Author getAuthorByFirstName(String firstName);
	public List<Author> findByEmailSorted(String email);
}