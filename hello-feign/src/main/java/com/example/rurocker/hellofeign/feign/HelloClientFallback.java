package com.example.rurocker.hellofeign.feign;

import org.springframework.stereotype.Component;

import com.example.rurocker.hellofeign.dto.HelloDto;

@Component
public class HelloClientFallback implements HelloClient {

	@Override
	public HelloDto getMessage(String message) {
		System.out.println(">>>>>>>>>>>>>>>>>> FALLBACK!!! <<<<<<<<<<<<<<<<<<<<");
		return new HelloDto("From fallback",-1l);
	}

}
