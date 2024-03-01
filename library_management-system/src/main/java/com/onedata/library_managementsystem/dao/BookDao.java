package com.onedata.library_managementsystem.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.onedata.library_managementsystem.dto.Book;
import com.onedata.library_managementsystem.repository.BookRepo;

@Repository
public class BookDao {
	
	@Autowired
	private BookRepo bookRepo;
	
	public Book createBook(Book book) {
		 Book save = bookRepo.save(book);
		return save;	
	}

	public List<Book> readAllBook() {
		List<Book> all = bookRepo.findAll();
		return all;
	}

	public Optional<Book> updateBook(int bookId) {
		Optional<Book> update = bookRepo.findById(bookId);
		return update;
	}
	
	public Optional<Book> deleteBook(int bookId) {
		Optional<Book> delete = bookRepo.findById(bookId);
		return delete;
	}

	public Optional<Book> findByBookTitle(String bookTitle) {
		Optional<Book> findByTitle = bookRepo.findByBookTitle(bookTitle);
		return findByTitle;
	}

	public Optional<Book> findByBookAuthor(String bookAuthor) {
		Optional<Book> findByAuthor = bookRepo.findByBookAuthor(bookAuthor);
		return findByAuthor;
	}
}
