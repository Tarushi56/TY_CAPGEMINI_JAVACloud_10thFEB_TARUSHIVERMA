package com.tyss.capgemini.loanproject.exception;

@SuppressWarnings("serial")
public class InvalidEmailFormatException extends RuntimeException{
	public InvalidEmailFormatException(String message) {
		super(message);
	}

}
