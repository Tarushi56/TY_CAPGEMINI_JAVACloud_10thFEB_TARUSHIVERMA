package com.tyss.capgemini.loanproject.exception;

@SuppressWarnings("serial")
public class UsernameAlreadyExistsException extends RuntimeException {
public UsernameAlreadyExistsException(String message) {
	super(message);
}
}
