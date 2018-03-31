package com.example.rurocker.helloapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason="To show an example of a custom message")
public class ValidationException extends RuntimeException{
	private static final long serialVersionUID = -3989363764704130947L;

}
