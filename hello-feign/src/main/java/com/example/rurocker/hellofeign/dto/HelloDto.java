package com.example.rurocker.hellofeign.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class HelloDto {

	private static AtomicInteger counter = new AtomicInteger();

	private Integer id;
	private String message;
	private Long timestamp;

	public HelloDto() {
		super();
	}

	public HelloDto(String message, Long timestamp) {
		this.id = counter.incrementAndGet();
		this.message = message;
		this.timestamp = timestamp;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}
