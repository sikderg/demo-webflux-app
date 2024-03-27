package com.example.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.model.User;
public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
