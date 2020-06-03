package com.cg.loanprocessing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.loanprocessing.entity.Client;
import com.cg.loanprocessing.entity.LoanForm;
import com.cg.loanprocessing.entity.LoanProgram;
import com.cg.loanprocessing.response.Response;

@ControllerAdvice
public class GenericExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<Response<Client>> handleException(ClientNotFoundException ex){
		Response<Client> response= new Response<>(true,ex.getMessage(),null);
		return new ResponseEntity<Response<Client>>(response,HttpStatus.NOT_FOUND);	
	}
	@ExceptionHandler
	public ResponseEntity<Response<LoanProgram>> handleException(LoanProgramNotFoundException ex){
		Response<LoanProgram> response= new Response<>(true,ex.getMessage(),null);
		return new ResponseEntity<Response<LoanProgram>>(response, HttpStatus.NOT_FOUND);	
	}
	@ExceptionHandler
	public ResponseEntity<Response<LoanForm>> handleException(ApplicationNotFoundException ex){
		Response<LoanForm> response= new Response<>(true,ex.getMessage(),null);
		return new ResponseEntity<Response<LoanForm>>(response, HttpStatus.NOT_FOUND);	
	}
}
