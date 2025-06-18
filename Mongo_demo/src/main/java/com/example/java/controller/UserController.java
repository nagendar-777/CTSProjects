package com.example.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.model.User;
import com.example.java.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public User createUser(@RequestBody User user)
	{
		return userService.createUser(user);
		
	}
	
	@GetMapping
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable String id, @RequestBody User user)
	{
		System.out.println(" PUT /api/users" + id + " body=" + user);
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable String id)
	{
		userService.deleteUser(id);
		
	}
}
