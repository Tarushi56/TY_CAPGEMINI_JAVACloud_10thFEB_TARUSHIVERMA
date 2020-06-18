package com.tyss.capgemini.loanproject.exception;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends RuntimeException{
	public InsufficientBalanceException(String message) {
		super(message);
	} 

}
