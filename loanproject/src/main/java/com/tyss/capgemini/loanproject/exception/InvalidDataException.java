package com.tyss.capgemini.loanproject.exception;

@SuppressWarnings("serial")
public class InvalidDataException extends RuntimeException {
public InvalidDataException(String message) {
	super(message);
}
}
