package com.vcube.securedigitalvault.user.dto;

import java.time.LocalDateTime;

import com.vcube.securedigitalvault.user.entity.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
	private Long id;
	private String username;
	private String email;
	private Role role;
	private LocalDateTime createdAt;
}
