package com.onedata.library_managementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onedata.library_managementsystem.dto.Member;
import com.onedata.library_managementsystem.repository.MemberRepo;

@Repository
public class MemberDao {

	@Autowired
	private  MemberRepo memberRepo;
	
	public  Member createMember(Member  member) {
		Member save = memberRepo.save(member);
		return save;	
	}
	
	public List<Member> readAllMember() {
		List<Member> all = memberRepo.findAll();
		return all;
	}

	public Optional<Member> updateMember(int memberId) {
		Optional<Member> update = memberRepo.findById(memberId);
		return update;
	}
	
	public Optional<Member> deleteMember(int memberId) {
		Optional<Member> delete = memberRepo.findById(memberId);
		return delete;
	}

}
