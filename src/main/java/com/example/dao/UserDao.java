/**
 * 
 */
package com.example.dao;

import com.example.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author goutam.sikder
 *
 */
public interface UserDao {

	Mono<User> findById(String id);

	Flux<User> findAll();

	Mono<User> createUser(User user);

	Mono<User> updateUser(User user);

	Mono<Void> deleteUserById(String id);

}
