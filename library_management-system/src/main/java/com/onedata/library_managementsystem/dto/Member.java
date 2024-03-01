package com.onedata.library_managementsystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="member_Id")
	private int memberId;
	@NotNull
	private String memberName;
	@NotNull
	private String memberPhone;
	@NotNull
	private String registeredDate;
}
