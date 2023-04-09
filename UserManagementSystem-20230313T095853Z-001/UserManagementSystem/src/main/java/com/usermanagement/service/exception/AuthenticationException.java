package com.usermanagement.service.exception;

public class AuthenticationException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mes;

	public AuthenticationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationException(String mes) {
		super("Please Login with admin user");
		this.mes = mes;
	}
	
	
	
}
