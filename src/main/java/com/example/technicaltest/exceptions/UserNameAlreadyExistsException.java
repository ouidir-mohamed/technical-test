package com.example.technicaltest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Exception thrown when a username is already taken.
 * Triggers a 403 Forbidden http error.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Username already exists")
public class UserNameAlreadyExistsException extends RuntimeException {
}
