package com.onedata.library_managementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onedata.library_managementsystem.dto.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
	Optional<Book> findByBookTitle(String bookTitle);
	Optional<Book> findByBookAuthor(String bookAuthor);
}
