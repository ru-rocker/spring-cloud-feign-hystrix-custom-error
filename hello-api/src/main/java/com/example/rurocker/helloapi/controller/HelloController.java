package com.example.rurocker.helloapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rurocker.helloapi.dto.HelloDto;
import com.example.rurocker.helloapi.exception.ValidationException;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public HelloDto getMessage(@RequestParam("message") String message) {
		if(message.equals("error")) {
			throw new ValidationException();
		}
		return new HelloDto(message, System.currentTimeMillis());
	}
}
