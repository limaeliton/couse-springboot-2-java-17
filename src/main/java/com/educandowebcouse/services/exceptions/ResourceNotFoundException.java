package com.educandowebcouse.services.exceptions;

// RuntimeException é uma exceção que o compilador não te obriga a tratar.
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. id " + id);
	}

}
