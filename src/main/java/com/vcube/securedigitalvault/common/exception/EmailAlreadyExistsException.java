package com.vcube.securedigitalvault.common.exception;

//raises when an email used for registration already exists
public class EmailAlreadyExistsException extends RuntimeException {
	public EmailAlreadyExistsException(String message) {
		super(message);
	}
}
