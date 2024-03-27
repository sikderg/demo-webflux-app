package com.example.service;

import com.example.dto.UserDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

	Mono<UserDto> findById(String id);

	Flux<UserDto> getAllUser();

	Mono<UserDto> createUser(UserDto userDto);

	Mono<UserDto> updateUser(String id, UserDto userDto);

	Mono<Void> deleteUser(String id);

}
