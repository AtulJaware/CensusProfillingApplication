package com.project.CensusProfiling.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserRegisterDto {

	private int userId;
	private String firstName;
	private String lastName;
	private LocalDate DOB;
	private String contactNo;
	private String email;
	private String password;
	private String role;
}
