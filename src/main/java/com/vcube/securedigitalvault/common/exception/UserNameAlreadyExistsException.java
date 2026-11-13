package com.vcube.securedigitalvault.common.exception;

//raises when a username used for registration already exists
public class UserNameAlreadyExistsException extends RuntimeException {

	public UserNameAlreadyExistsException(String message) {
		super(message);
	}

}
