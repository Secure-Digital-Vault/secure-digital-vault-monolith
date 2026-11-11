package com.vcube.securedigitalvault.vault.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documents")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long ownerId;
	private String originalName;
	private String storedName;
	private String contentType;
	private Long fileSize;
	private String storagePath;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
