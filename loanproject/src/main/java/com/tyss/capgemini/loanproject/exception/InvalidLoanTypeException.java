package com.tyss.capgemini.loanproject.exception;

@SuppressWarnings("serial")
public class InvalidLoanTypeException extends RuntimeException {
	public InvalidLoanTypeException(String message) {
		super(message);

	}
}
