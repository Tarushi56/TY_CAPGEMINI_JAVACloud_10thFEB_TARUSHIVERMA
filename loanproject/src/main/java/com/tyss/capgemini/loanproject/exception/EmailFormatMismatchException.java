package com.tyss.capgemini.loanproject.exception;

@SuppressWarnings("serial")
public class EmailFormatMismatchException extends RuntimeException{
public EmailFormatMismatchException(String d) {
	super(d);
}
}
