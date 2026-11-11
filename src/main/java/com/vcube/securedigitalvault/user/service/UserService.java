package com.vcube.securedigitalvault.user.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.vcube.securedigitalvault.user.entity.Role;
import com.vcube.securedigitalvault.user.entity.User;
import com.vcube.securedigitalvault.user.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User register(User user) {
		user.setRole(Role.USER);
		user.setEnabled(true);
		user.setCreatedAt(LocalDateTime.now());
		return userRepository.save(user);
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

}
