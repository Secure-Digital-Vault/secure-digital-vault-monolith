package com.vcube.securedigitalvault.user.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String email;
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

//	@JsonProperty(defaultValue = "true")
	private Boolean enabled;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
