package com.onedata.library_managementsystem.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.onedata.library_managementsystem.dto.Member;
import com.onedata.library_managementsystem.repository.MemberRepo;
import com.onedata.library_managementsystem.response_structure.ResponseStructure;
import com.onedata.library_managementsystem.service_implementation.MemberServiceImple;

@RestController
public class MemberController {
	
	@Autowired
	private MemberServiceImple memberServiceImple;
	@Autowired
	private MemberRepo memberRepo;
	
	@PostMapping("/CreateMemberData")
	public ResponseEntity<?> createMemberData(@RequestBody Member  member){
		ResponseStructure<Member> save = memberServiceImple.createMember(member);
		return new ResponseEntity<>(save, HttpStatus.CREATED);
	}
	
	@GetMapping("/readAllMember")
	public ResponseEntity<?> readAllMember() {	
		ResponseStructure<List<Member>> allMember = memberServiceImple.readAllMember();
		return new ResponseEntity<>(allMember, HttpStatus.OK);	
	}
	
	@PutMapping("/updateMember")
	public ResponseEntity<?> updateMember(@RequestBody Member member) {
		Optional<Member> update = memberServiceImple.updateMember(member.getMemberId());
		if(update.isPresent()) {
			memberRepo.save(member);
			return new ResponseEntity<>("Member updated successfully", HttpStatus.OK);
		}
		else{
			throw new IllegalArgumentException("Invaild id");	
		}	
	}	
	
	
	@DeleteMapping("/deleteMember/{memberId}")
	public ResponseEntity<?> deleteMember(@PathVariable int memberId) {
		Optional<Member> deleteId = memberServiceImple.deleteMember(memberId);
		if(deleteId.isPresent()) {
			memberRepo.delete(deleteId.get());
			return new ResponseEntity<>("Member deleted successfully", HttpStatus.OK);
		}
		else{
			throw new IllegalArgumentException("Invaild id");	
		}
	}
}
