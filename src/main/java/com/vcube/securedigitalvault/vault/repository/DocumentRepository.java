package com.vcube.securedigitalvault.vault.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.securedigitalvault.vault.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

}
