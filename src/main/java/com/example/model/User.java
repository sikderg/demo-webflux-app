package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;

@Document("app_user") @Data
public class User {
	
	@Id
	private String id;
	@Field("first_name")
	private String firstName;
	@Field("last_name")
	private String lastName;
	@Field("email")
	private String email;
	@Field("gender")
	private String gender;
	@Field("ip_address")
	private String ipAddress;

}
