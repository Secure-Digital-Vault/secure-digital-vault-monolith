package com.vcube.securedigitalvault.user.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vcube.securedigitalvault.common.exception.EmailAlreadyExistsException;
import com.vcube.securedigitalvault.common.exception.UserNameAlreadyExistsException;
import com.vcube.securedigitalvault.user.dto.UserRegistrationRequest;
import com.vcube.securedigitalvault.user.dto.UserResponse;
import com.vcube.securedigitalvault.user.entity.Role;
import com.vcube.securedigitalvault.user.entity.User;
import com.vcube.securedigitalvault.user.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public UserResponse registerUser(UserRegistrationRequest request) {
		// Check if username already exists
		if (userRepository.existsByUsername(request.getUsername())) {
			throw new UserNameAlreadyExistsException("Username already exists: " + request.getUsername());
		}

		// Check if email already exists
		if (userRepository.existsByEmail(request.getEmail())) {
			throw new EmailAlreadyExistsException("Email already exists: " + request.getEmail());
		}

		// BCryptPasswordEncoder.encode() returns a String (BCrypt hash format)
		String passwordHash = passwordEncoder.encode(request.getPassword());

		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(passwordHash);
		user.setRole(Role.USER);

		userRepository.save(user);

		return mapToResponse(user);
	}

	public UserResponse getUserById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));

		return mapToResponse(user);
	}

//	DTO Mapping
//	It is an internal helper method, so there is no reason to expose it publicly. Thus, it is defined private 
	private UserResponse mapToResponse(User user) {
		UserResponse response = new UserResponse();

		response.setId(user.getId());
		response.setUsername(user.getUsername());
		response.setEmail(user.getEmail());
		response.setRole(user.getRole());
		response.setCreatedAt(user.getCreatedAt());

		return response;
	}

}
