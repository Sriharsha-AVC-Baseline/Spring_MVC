package com.itt.util;

public class InvalidDateException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidDateException(String errorMessage)
	{
		super(errorMessage);
	}
	
}
