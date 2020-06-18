package com.tyss.capgemini.loanproject.exception;

@SuppressWarnings("serial")
public class InvalidCredentialsException extends RuntimeException{
public InvalidCredentialsException(String h) {
	super(h);
}
}
