package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import com.example.handler.UserHandler;

@Configuration
public class RouterConfig {

	@Bean
	RouterFunction<ServerResponse> routes(UserHandler userHandler) {
		return route(GET("/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::getUserById)
				.andRoute(GET("/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::getUsers)
				.andRoute(POST("/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::createUser)
				.andRoute(PUT("/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::updateUser)
				.andRoute(DELETE("/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::deleteUser);
	}
}
