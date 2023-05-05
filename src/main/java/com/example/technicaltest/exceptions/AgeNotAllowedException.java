package com.example.technicaltest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Exception thrown when a user's age is not allowed to register.
 * Triggers a 403 Forbidden http error.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Not allowed age")
public class AgeNotAllowedException extends RuntimeException {
}
