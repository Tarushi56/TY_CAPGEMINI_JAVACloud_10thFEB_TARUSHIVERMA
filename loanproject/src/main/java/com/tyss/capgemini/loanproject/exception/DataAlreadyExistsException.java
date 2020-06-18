package com.tyss.capgemini.loanproject.exception;

@SuppressWarnings("serial")
public class DataAlreadyExistsException extends RuntimeException {
public  DataAlreadyExistsException(String message) {
	super(message) ;
}
}
