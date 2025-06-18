package com.example.java.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.model.User;
import com.example.java.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private final UserRepository repo;


	public UserService(UserRepository repo) {
		this.repo = repo;

	}

	public List<User> getAllUsers() {
		return repo.findAll();

	}

	public User getUserById(String id) {
		return repo.findById(id).orElse(null);

	}

	public User createUser(User user) {
		// 1. Generate a new random ID
		String id = UUID.randomUUID().toString();
		  // 2. Build a new User record with that ID and the provided data
	    User saveUser = new User(
	        id,
	        user.name(),
	        user.email(),
	        user.age()
	    );		
	    return repo.save(saveUser);

	}

	public User updateUser(String id, User updateUser) {
		User existing = repo.findById(id).orElse(null);
		if (existing != null) {
			// Create a new record instance with updated values
			User updated = new User(existing.id(), updateUser.name(), updateUser.email(), updateUser.age());
			System.out.println("Updating user ID: " + id);
			System.out.println("Payload: " + updated);
			return repo.save(updated);
			
		}
		return null;

	}

	public void deleteUser(String id) {
		repo.deleteById(id);
			}

}
