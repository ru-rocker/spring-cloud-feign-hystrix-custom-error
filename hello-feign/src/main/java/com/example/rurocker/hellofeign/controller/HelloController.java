package com.example.rurocker.hellofeign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rurocker.hellofeign.dto.HelloDto;
import com.example.rurocker.hellofeign.feign.HelloClient;

@RestController
public class HelloController {

	@Autowired
	private HelloClient helloClient;
	
	@GetMapping("/hello")
	public HelloDto getMessage(@RequestParam("message") String message) {
		return helloClient.getMessage(message);
	}
}
