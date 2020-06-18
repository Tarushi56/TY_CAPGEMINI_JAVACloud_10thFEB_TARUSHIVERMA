package com.cg.loanprocessing.response;

import java.io.Serializable; 

import lombok.Data;
@Data
public class JwtResponse implements Serializable {
 private static final long serialVersionUID=-8091879091924046844L;
 private final String jwttoken ;
 private final String email ;
 private final String error ;
 private final String role ;
 private final String fullName ;
 private final int loanId;
public JwtResponse(String jwttoken,String email,int loanId, String error, String role, String fullName) {
	this.jwttoken = jwttoken;
	this.email = email;
	this.error = error;
	this.role = role;
	this.fullName = fullName;
	this.loanId=loanId;
}
 

}
