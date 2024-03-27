package com.example.dao;

import org.springframework.stereotype.Repository;

import com.example.model.User;
import com.example.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author goutam.sikder
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	private final UserRepository userRepository;

	public UserDaoImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Mono<User> findById(String id) {
		return userRepository.findById(id);
	}

	@Override
	public Flux<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Mono<User> createUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public Mono<User> updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Mono<Void> deleteUserById(String id) {
		return userRepository.deleteById(id);
	}

}
