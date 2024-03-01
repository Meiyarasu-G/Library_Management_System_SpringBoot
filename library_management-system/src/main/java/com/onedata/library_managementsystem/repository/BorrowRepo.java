package com.onedata.library_managementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onedata.library_managementsystem.dto.Borrow;

@Repository
public interface BorrowRepo extends JpaRepository<Borrow, Integer> {

//	@Query(value = "SELECT * FROM borrow", nativeQuery = true)
//	Borrow getAll();

}
