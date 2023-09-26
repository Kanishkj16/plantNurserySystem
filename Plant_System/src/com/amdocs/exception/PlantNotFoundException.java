package com.amdocs.exception;


public class PlantNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message ="Plant with given id isnt available.";
	
	public PlantNotFoundException(String message)
	{
		super(message);
	}

	@Override
	public String toString() {
		return "PlantNotFoundException [message=" + message + "]";
	}
}