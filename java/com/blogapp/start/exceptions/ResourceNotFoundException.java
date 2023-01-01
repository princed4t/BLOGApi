package com.blogapp.start.exceptions;


public class ResourceNotFoundException extends RuntimeException{
	 String message;

	public ResourceNotFoundException(String message) {
		super(message);
		this.message=message;
	}
	
	

	

}
