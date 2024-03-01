package com.onedata.library_managementsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onedata.library_managementsystem.dto.Borrow;
import com.onedata.library_managementsystem.response_structure.ResponseStructure;
import com.onedata.library_managementsystem.service_implementation.BorrowServiceImple;

@RestController
public class BorrowController {
	
	@Autowired
	private BorrowServiceImple borrowServiceImple;
	
	//create borrow after only the given records are matching
    @PostMapping("/borrow/{memberId}/{bookId}")
    public ResponseEntity<?> borrowBook(@PathVariable int memberId, @PathVariable int bookId) {
    	ResponseStructure<Borrow> borrowBook = borrowServiceImple.borrowBook(memberId, bookId);
        return new ResponseEntity<>(borrowBook, HttpStatus.CREATED);
    }

    @GetMapping("/readAllBorrow")
	public ResponseEntity<?> readAllBorrow() {
		ResponseStructure<List<Borrow>> allBorrow = borrowServiceImple.readAllBorrow();
	    return new ResponseEntity<>(allBorrow, HttpStatus.OK);
	}
    
    @PutMapping("/returnBook/{borrowId}")
    public ResponseEntity<?> returnBook(@PathVariable int borrowId) {
        String returnedBook = borrowServiceImple.returnBook(borrowId);
        return new ResponseEntity<>(returnedBook, HttpStatus.OK);
    }

}
