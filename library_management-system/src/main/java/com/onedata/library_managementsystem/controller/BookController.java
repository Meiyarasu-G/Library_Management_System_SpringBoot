package com.onedata.library_managementsystem.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.onedata.library_managementsystem.dto.Book;
import com.onedata.library_managementsystem.repository.BookRepo;
import com.onedata.library_managementsystem.response_structure.ResponseStructure;
import com.onedata.library_managementsystem.service_implementation.BookServiceImple;

@RestController
public class BookController {
	
	@Autowired
	private BookServiceImple bookServiceImple;
	@Autowired
	private BookRepo bookRepo;
	
	
	@PostMapping("/CreateBookData")
	public ResponseEntity<?> createBookData(@RequestBody Book book){
		ResponseStructure<Book> save = bookServiceImple.createBook(book);
		return new ResponseEntity<>(save, HttpStatus.CREATED);
	}
	
	@GetMapping("/readAllBook")
	public ResponseEntity<?> readAllBook() {	
		ResponseStructure<List<Book>> allBook = bookServiceImple.readAllBook();
		return new ResponseEntity<>(allBook, HttpStatus.OK);	
	}
	
	@PutMapping("/updateBook")
	public ResponseEntity<?> updateBook(@RequestBody Book book) {
		Optional<Book> update = bookServiceImple.updateBook(book.getBookId());
		if(update.isPresent()) {
			bookRepo.save(book);
			return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
		}
		else{
			throw new IllegalArgumentException("Invaild id");	
		}	
	}	
	
	@DeleteMapping("/deleteBook/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable int bookId) {
		Optional<Book> deleteId = bookServiceImple.deleteBook(bookId);
		if(deleteId.isPresent()) {
			bookRepo.delete(deleteId.get());
			return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
		}
		else{
			throw new IllegalArgumentException("Invaild id");	
		}
	}
	
	
	@GetMapping("/findBookByTitle/{bookTitle}")
	public ResponseEntity<?> findByBookTitle(@PathVariable String bookTitle) {
		Optional<Book> findByTitle = bookServiceImple.findByBookTitle(bookTitle);
			return new  ResponseEntity<>(findByTitle, HttpStatus.OK); 
	}
			
	@GetMapping("/findBookByAuthor/{bookAuthor}")
	public  ResponseEntity<?> findByBookAuthor(@PathVariable String bookAuthor) {
		Optional<Book> findByAuthor = bookServiceImple.findByBookAuthor(bookAuthor);
			return new ResponseEntity<>(findByAuthor, HttpStatus.OK);
	}
}

