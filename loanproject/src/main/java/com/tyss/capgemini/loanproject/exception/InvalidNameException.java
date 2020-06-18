package com.tyss.capgemini.loanproject.exception;

@SuppressWarnings("serial")
public class InvalidNameException  extends RuntimeException {
	public InvalidNameException(String message) {
		super(message);
	}
}
