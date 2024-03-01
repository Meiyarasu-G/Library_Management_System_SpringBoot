package com.onedata.library_managementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.onedata.library_managementsystem.dto.Member;
import com.onedata.library_managementsystem.response_structure.ResponseStructure;

@Service
public interface MemberService {
	ResponseStructure<Member> createMember(Member member);
	ResponseStructure<List<Member>> readAllMember();
	Optional<Member> updateMember(int memberId);
	Optional<Member> deleteMember(int memberId);
	
}
