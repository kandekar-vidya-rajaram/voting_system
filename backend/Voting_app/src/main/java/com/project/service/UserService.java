package com.project.service;


	import com.project.model.User;
	import java.util.List;
	import java.util.Optional;

	public interface UserService {

	    // Register a new user
	    User registerUser(User user);

	    // Get all users
	    List<User> getAllUsers();

	    // Get user by ID
	    Optional<User> getUserById(Long id);

	    // Get user by email
	    Optional<User> getUserByEmail(String email);

	    // Delete user by ID
	    void deleteUser(Long id);
	}


