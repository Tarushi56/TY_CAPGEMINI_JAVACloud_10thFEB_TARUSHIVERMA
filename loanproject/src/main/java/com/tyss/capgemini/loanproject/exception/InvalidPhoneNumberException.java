package com.tyss.capgemini.loanproject.exception;

@SuppressWarnings("serial")
public class InvalidPhoneNumberException extends RuntimeException{
	public InvalidPhoneNumberException(String message) {
		super(message);
	}

}
