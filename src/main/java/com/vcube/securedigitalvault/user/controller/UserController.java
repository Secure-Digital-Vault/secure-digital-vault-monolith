package com.vcube.securedigitalvault.user.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vcube.securedigitalvault.user.dto.UserRegistrationRequest;
import com.vcube.securedigitalvault.user.dto.UserResponse;
import com.vcube.securedigitalvault.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRegistrationRequest request) {
		UserResponse response = userService.registerUser(request);

//		building the Location header for the response
//		ServletUriComponentsBuilder is a utility class in Spring that helps build URI components from HTTP requests
		URI location = ServletUriComponentsBuilder.fromCurrentRequest() // Starts building from the current request URI
				.path("/{id}") // Appends "/{id}" to the path
				.buildAndExpand(response.getId()) // Replaces {id} with the actual user ID
				.toUri(); // Converts to a URI object

//		This pattern follows RESTful conventions where:
//			POST to a collection endpoint creates a new resource
//			The response includes the location of the new resource
//			The response body contains the created resource representation

		return ResponseEntity.created(location).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}
}
