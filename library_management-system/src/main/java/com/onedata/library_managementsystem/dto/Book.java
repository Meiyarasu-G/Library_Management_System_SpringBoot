package com.onedata.library_managementsystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_Id")
	private int bookId;
	@NotNull
	private String bookTitle;
	@NotNull
	private String bookAuthor;
	@NotNull
	private String bookIsbn;
	@NotNull
	private String publishedDate;
	@NotNull
	@Positive
	private int availabeCopies; 
	
}
