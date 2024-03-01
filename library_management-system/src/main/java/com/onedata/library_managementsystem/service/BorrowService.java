package com.onedata.library_managementsystem.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.onedata.library_managementsystem.dto.Borrow;
import com.onedata.library_managementsystem.response_structure.ResponseStructure;

@Service
public interface BorrowService {
	ResponseStructure<Borrow> borrowBook(int memberId, int bookId);
	ResponseStructure<List<Borrow>> readAllBorrow();
	String returnBook(int borrowId);
}
