/**
 * 
 */
package com.example.service.impl;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.dto.UserDto;
import com.example.model.User;
import com.example.modelmapper.UserMappper;
import com.example.repository.UserRepository;
import com.example.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author goutam.sikder
 *
 */

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;
	
	private final UserMappper userMapper;
	

	public UserServiceImpl( UserMappper userMapper, UserDao userDao) {
		this.userDao = userDao;
		this.userMapper = userMapper;
	}


	@Override
	public Mono<UserDto> findById(String id) {
		return userDao.findById(id).map(userMapper::toDto);
	}



	@Override
	public Flux<UserDto> getAllUser() {
		return userDao.findAll().map(userMapper::toDto);//.delayElements(Duration.ofMillis(100));
	}


	@Override
	public Mono<UserDto> createUser(UserDto userDto) {
		User user = userMapper.toModel(userDto);
		return userDao.createUser(user).map(userMapper::toDto);
	}


	@Override
	public Mono<UserDto> updateUser(String id,UserDto userDto) {
		User user = userMapper.toModel(userDto);
		return userDao.findById(id).flatMap(userDB -> {
			userDB.setFirstName(userDto.getFirstName());
			userDB.setLastName(userDto.getLastName());
			userDB.setGender(userDto.getGender());
			userDB.setEmail(userDto.getEmail());
			userDB.setIpAddress(userDto.getIpAddress());
			return userDao.createUser(user);
		}).map(userMapper::toDto);
	}


	@Override
	public Mono<Void> deleteUser(String id) {
		return userDao.deleteUserById(id);
	}
	
}
