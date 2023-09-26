package com.app.VetPetShop.CustomExceptions;

@SuppressWarnings("serial")
public class EntityNotFoundException extends RuntimeException {
	
	public EntityNotFoundException(String message) {
		super(message);
	}

}
