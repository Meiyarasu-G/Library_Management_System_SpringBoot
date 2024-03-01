package com.onedata.library_managementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onedata.library_managementsystem.dto.Borrow;
import com.onedata.library_managementsystem.repository.BorrowRepo;

@Repository
public class BorrowDao {

	@Autowired
	private BorrowRepo borrowRepo;
	
	public List<Borrow> readAllBorrow() {
		List<Borrow> all = borrowRepo.findAll();
		return all;
	}

	public Borrow createBorrow(Borrow borrow) {
		Borrow saveBorrow = borrowRepo.save(borrow);
		return saveBorrow;
	}

	public Optional<Borrow> findById(int borrowId) {
		Optional<Borrow> byId = borrowRepo.findById(borrowId);
		return byId;
	}

}
