package com.onedata.library_managementsystem.service_implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onedata.library_managementsystem.dao.MemberDao;
import com.onedata.library_managementsystem.dto.Member;
import com.onedata.library_managementsystem.response_structure.ResponseStructure;
import com.onedata.library_managementsystem.service.MemberService;

@Service
public class MemberServiceImple implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public ResponseStructure<Member> createMember(Member member) {
		Member save = memberDao.createMember(member);
		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		structure.setData(save);
		structure.setDateTime(LocalDateTime.now());
		structure.setMessage("Data inserted sucessfully"); 
		structure.setStatusCode(201);
		return structure;
	}

	@Override
	public ResponseStructure<List<Member>> readAllMember() {
		List<Member> allMember = memberDao.readAllMember();
		ResponseStructure<List<Member>> structure = new ResponseStructure<List<Member>>();
		structure.setData(allMember);
		structure.setDateTime(LocalDateTime.now());
		structure.setMessage("All data reterived sucessfully");
		structure.setStatusCode(201);
		return structure;
	}


	@Override
	public Optional<Member> updateMember(int memberId) {
		Optional<Member> update = memberDao.updateMember(memberId);
		return update;
	}

	@Override
	public Optional<Member> deleteMember(int memberId) {
		Optional<Member> delete = memberDao.deleteMember(memberId);
		return delete;
	}

}
