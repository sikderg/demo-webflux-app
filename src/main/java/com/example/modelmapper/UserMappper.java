package com.example.modelmapper;

import org.springframework.stereotype.Component;

import com.example.dto.UserDto;
import com.example.model.User;

@Component
public class UserMappper {
	public UserDto toDto(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setFullName(dto.getFirstName() +" "+ dto.getLastName());
		dto.setEmail(user.getEmail());
		dto.setGender(user.getGender());
		dto.setIpAddress(user.getIpAddress());
		return dto;
	}

	public User toModel(UserDto dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setGender(dto.getGender());
		user.setIpAddress(dto.getIpAddress());
		return user;
	}
}
