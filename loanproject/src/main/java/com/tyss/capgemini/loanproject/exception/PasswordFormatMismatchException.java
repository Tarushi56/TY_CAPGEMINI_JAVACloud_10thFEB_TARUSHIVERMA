package com.tyss.capgemini.loanproject.exception;

@SuppressWarnings("serial")
public class PasswordFormatMismatchException extends RuntimeException{
	public PasswordFormatMismatchException(String massage) {
		super(massage);
	}

}
