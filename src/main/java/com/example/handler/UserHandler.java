package com.example.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.dto.UserDto;
import com.example.service.UserService;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {

	private final UserService userService;

	public UserHandler(UserService userService) {
		this.userService = userService;
	}

	public Mono<ServerResponse> getUserById(ServerRequest request) {
		String id = request.pathVariable("id");
		return userService.findById(id)
				.flatMap(user -> ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.bodyValue(user))
				.switchIfEmpty(ServerResponse.notFound().build());
	}

	public Mono<ServerResponse> getUsers(ServerRequest request) {
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(userService.getAllUser(), UserDto.class);
	}

	public Mono<ServerResponse> createUser(ServerRequest request) {
		Mono<UserDto> userMono = request.bodyToMono(UserDto.class);
		return userMono.flatMap(userDto -> userService
				.createUser(userDto)
				.flatMap(book -> ServerResponse.status(HttpStatus.CREATED)
						.contentType(MediaType.APPLICATION_JSON)
						.bodyValue(book)));
	}
	
	public Mono<ServerResponse> updateUser(ServerRequest request) {
		String id = request.pathVariable("id");
		Mono<UserDto> userMono = request.bodyToMono(UserDto.class);
		return userMono.flatMap(userDTO -> ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(userService.updateUser(id, userDTO),UserDto.class));
	}
	
	public Mono<ServerResponse> deleteUser(ServerRequest request) {
		String id = request.pathVariable("id");
		return userService.deleteUser(id)
				.then(ServerResponse.ok().build())
				.switchIfEmpty(ServerResponse.notFound().build());
	}
}
