package com.onedata.library_managementsystem.service_implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onedata.library_managementsystem.dao.BookDao;
import com.onedata.library_managementsystem.dto.Book;
import com.onedata.library_managementsystem.response_structure.ResponseStructure;
import com.onedata.library_managementsystem.service.BookService;

@Service
public class BookServiceImple implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public ResponseStructure<Book> createBook(Book book) {
		Book save = bookDao.createBook(book);
		ResponseStructure<Book> structure = new ResponseStructure<Book>();
		structure.setData(save);
		structure.setDateTime(LocalDateTime.now());
		structure.setMessage("Data inserted sucessfully");
		structure.setStatusCode(201);
		return structure;
	}

	@Override
	public ResponseStructure<List<Book>> readAllBook() {
		List<Book> allBook = bookDao.readAllBook();
		ResponseStructure<List<Book>> structure = new ResponseStructure<List<Book>>();
		structure.setData(allBook);
		structure.setDateTime(LocalDateTime.now());
		structure.setMessage("All data reterived sucessfully");
		structure.setStatusCode(201);
		return structure;
	}

	@Override
	public Optional<Book> updateBook(int bookId) {
		Optional<Book> update = bookDao.updateBook(bookId);
		return update;
	}

	@Override
	public Optional<Book> deleteBook(int bookId) {
		Optional<Book> delete = bookDao.deleteBook(bookId);
		return delete;
	}

	@Override
	public Optional<Book> findByBookTitle(String bookTitle) {
		Optional<Book> findByTitle = bookDao.findByBookTitle(bookTitle);
		return findByTitle;
	}

	@Override
	public Optional<Book> findByBookAuthor(String bookAuthor) {
		Optional<Book> findByAuthor = bookDao.findByBookAuthor(bookAuthor);
		return findByAuthor;
	}	
}
