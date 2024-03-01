package com.onedata.library_managementsystem.service_implementation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onedata.library_managementsystem.dao.BorrowDao;
import com.onedata.library_managementsystem.dto.Book;
import com.onedata.library_managementsystem.dto.Borrow;
import com.onedata.library_managementsystem.dto.Member;
import com.onedata.library_managementsystem.repository.BookRepo;
import com.onedata.library_managementsystem.repository.MemberRepo;
import com.onedata.library_managementsystem.response_structure.ResponseStructure;
import com.onedata.library_managementsystem.service.BorrowService;

@Service
public class BorrowServiceImple implements BorrowService {
	
	@Autowired
	private BorrowDao borrowDao;
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private MemberRepo memberRepo;
	
	@Override
	public ResponseStructure<Borrow> borrowBook(int memberId, int bookId) {
		
		Member member = memberRepo.findById(memberId)
				.orElseThrow(() -> new IllegalArgumentException("Member Id is not found -->Please Register Member Details"));
		
		Book book = bookRepo.findById(bookId)
				.orElseThrow(() -> new IllegalArgumentException("Book Id not Available / not Found"));
		
		if(book.getAvailabeCopies()>0) {
			int reduce = book.getAvailabeCopies()-1;
			book.setAvailabeCopies(reduce);
			bookRepo.save(book);
			
			Borrow borrow = new Borrow();
			borrow.setBook(book);
			borrow.setMember(member);
			borrow.setBorrowDate(LocalDateTime.now());
			borrow.setDueDate(LocalDate.now().plusWeeks(1));
			
			Borrow save = borrowDao.createBorrow(borrow);
			ResponseStructure<Borrow> structure = new ResponseStructure<Borrow>();
			structure.setData(save);
			structure.setDateTime(LocalDateTime.now());
			structure.setMessage("Book Borrowed sucessfully **READ WELL** "); 
			structure.setStatusCode(201);
			return structure;
		}
		else {
            throw new IllegalArgumentException("Book is not available for borrowing");
        }
	}
	
	@Override
	public ResponseStructure<List<Borrow>> readAllBorrow() {
		List<Borrow> allBorrow = borrowDao.readAllBorrow();
		ResponseStructure<List<Borrow>> structure = new ResponseStructure<List<Borrow>>();
		structure.setData(allBorrow);
		structure.setDateTime(LocalDateTime.now());
		structure.setMessage("All data reterived sucessfully");
		structure.setStatusCode(201);
		return structure;
	}

	
	@Override
	public String returnBook(int borrowId) {
		 Borrow borrow = borrowDao.findById(borrowId)
				 .orElseThrow(() -> new IllegalArgumentException("Borrow record not found"));

		 Book book = borrow.getBook();
		 book.setAvailabeCopies(book.getAvailabeCopies()+1);
		 bookRepo.save(book);	
		 return "Book Returned sucessfully";
	}
	
}
