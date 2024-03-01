package com.onedata.library_managementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onedata.library_managementsystem.dto.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {

}
