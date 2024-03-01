package com.onedata.library_managementsystem.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.onedata.library_managementsystem.dto.Book;
import com.onedata.library_managementsystem.response_structure.ResponseStructure;

@Service
public interface BookService {
	ResponseStructure<Book> createBook(Book book);
	ResponseStructure<List<Book>> readAllBook();
	Optional<Book> updateBook(int bookId);
	Optional<Book> deleteBook(int bookId);
	Optional<Book> findByBookTitle(String bookTitle);
	Optional<Book> findByBookAuthor(String bookAuthor);
}
