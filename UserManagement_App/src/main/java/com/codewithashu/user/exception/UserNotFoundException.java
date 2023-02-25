package com.codewithashu.user.exception;

public class UserNotFoundException extends RuntimeException{
	
	String resourceName;
	
	String fieldName;
	
	long fieldValue;

	public UserNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	
	

}
