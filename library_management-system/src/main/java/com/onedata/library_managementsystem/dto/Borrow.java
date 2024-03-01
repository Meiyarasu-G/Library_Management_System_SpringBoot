package com.onedata.library_managementsystem.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Borrow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int borrowId;
	@ManyToOne
	@JoinColumn(name="member_Id")
	private Member member;
	@ManyToOne
	@JoinColumn(name="book_Id")
	private Book book;
	private LocalDateTime borrowDate;
	private LocalDate dueDate;
}
