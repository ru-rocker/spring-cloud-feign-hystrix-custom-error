package com.example.rurocker.hellofeign.decoder;

import com.example.rurocker.hellofeign.exception.ValidationException;
import com.netflix.hystrix.exception.HystrixBadRequestException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(String endpoint, Response response) {
		if(response.status() == 412) {
			throw new HystrixBadRequestException("Error kk", new ValidationException());
		}
		return defaultErrorDecoder.decode(endpoint, response);
	}
}
