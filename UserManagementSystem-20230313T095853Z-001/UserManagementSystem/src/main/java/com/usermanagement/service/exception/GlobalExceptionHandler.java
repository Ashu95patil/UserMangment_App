package com.usermanagement.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.usermanagement.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<ApiResponse>  resourcenotfoundexception(ResourceNotFoundException ex)
	{
		String message=ex.getMessage();
		
		ApiResponse apiResponse = new ApiResponse(message, false);
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
		
	}
	
	
	
	@ExceptionHandler(AuthenticationException.class)
	ResponseEntity<ApiResponse>  AuthenticationException(AuthenticationException ex)
	{
		String message=ex.getMessage();
		
		System.out.println(message);
		
		ApiResponse apiResponse = new ApiResponse(message, false);
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
		
	}
	
}
