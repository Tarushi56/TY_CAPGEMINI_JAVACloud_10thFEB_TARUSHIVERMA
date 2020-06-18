package com.tyss.capgemini.loanproject.exception;

@SuppressWarnings("serial")
public class DateFormatMismatchException extends RuntimeException {
	public DateFormatMismatchException (String s ) {
		super(s);
	}

}
