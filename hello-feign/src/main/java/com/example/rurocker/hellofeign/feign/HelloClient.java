package com.example.rurocker.hellofeign.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rurocker.hellofeign.dto.HelloDto;

@FeignClient(name = "HELLO-API", fallback = HelloClientFallback.class)
public interface HelloClient {

	@GetMapping("/hello")
	public HelloDto getMessage(@RequestParam("message") String message);
}
