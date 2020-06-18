package com.tyss.capgemini.loanproject.exception;

@SuppressWarnings("serial")
public class InvalidNumberException extends RuntimeException {
	public InvalidNumberException (String message){
		super(message);
	}
}
