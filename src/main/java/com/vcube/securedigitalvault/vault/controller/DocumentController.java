package com.vcube.securedigitalvault.vault.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vcube.securedigitalvault.vault.service.DocumentService;

@RestController
public class DocumentController {
	private final DocumentService documentService;

	public DocumentController(DocumentService documentService) {
		super();
		this.documentService = documentService;
	}

}
