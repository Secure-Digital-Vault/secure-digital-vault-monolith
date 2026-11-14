package com.vcube.securedigitalvault.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//raises when a username used for registration already exists
@ResponseStatus(HttpStatus.CONFLICT)
public class UserNameAlreadyExistsException extends RuntimeException {

	public UserNameAlreadyExistsException(String message) {
		super(message);
	}

}
