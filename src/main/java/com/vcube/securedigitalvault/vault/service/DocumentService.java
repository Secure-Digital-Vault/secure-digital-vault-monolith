package com.vcube.securedigitalvault.vault.service;

import org.springframework.stereotype.Service;

import com.vcube.securedigitalvault.vault.repository.DocumentRepository;

@Service
public class DocumentService {
	private final DocumentRepository documentRepository;

	public DocumentService(DocumentRepository documentRepository) {
		super();
		this.documentRepository = documentRepository;
	}

}
