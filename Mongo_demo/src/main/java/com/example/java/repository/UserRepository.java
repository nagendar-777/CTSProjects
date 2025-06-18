package com.example.java.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.java.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
