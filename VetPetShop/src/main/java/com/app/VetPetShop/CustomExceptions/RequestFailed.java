package com.app.VetPetShop.CustomExceptions;

@SuppressWarnings("serial")
public class RequestFailed extends RuntimeException {
	
	public RequestFailed(String message)
	{
		super(message);
	}
	
}
