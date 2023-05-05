package com.example.technicaltest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Not allowed Country")
public class CountryNotAllowedException extends RuntimeException { }