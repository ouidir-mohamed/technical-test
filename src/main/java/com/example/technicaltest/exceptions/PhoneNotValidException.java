package com.example.technicaltest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Exception thrown when a user's phone number is not valid.
 * Triggers a 403 Forbidden http error.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Not valid phone number")
public class PhoneNotValidException extends RuntimeException {
}