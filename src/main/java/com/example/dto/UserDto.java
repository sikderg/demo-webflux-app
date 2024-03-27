package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class UserDto {
	
	private String id;
	private String firstName;
	private String lastName;
	private String fullName;
	private String email;
	private String gender;
	private String ipAddress;

}
