package com.tyss.capgemini.loanproject.validation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Validation {
	static Logger logger=LogManager.getLogger(Validation.class);
	static Scanner scanner=new Scanner(System.in);
	private Pattern pattern1,pattern2,pattern3,pattern4,pattern5;
	private Matcher matcher1,matcher2,matcher3,matcher4,matcher5;
	private static final String password_pattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$%_@]).{6,20})";
	private static final String date_pattern = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
	private static final String phone_pattern="^[6-9]\\d{9}$";
	private static final String email_pattern="^[a-zA-Z0-9]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
            "A-Z]{2,7}$"; 
	private static final String username_pattern="^[a-z0-9_@-]{3,15}$";
	public Validation() {
		pattern1=Pattern.compile(password_pattern);
		pattern2=Pattern.compile(date_pattern);
		pattern3=Pattern.compile(email_pattern);
		pattern4=Pattern.compile(username_pattern) ;
		pattern5=Pattern.compile(phone_pattern);
	}

	public boolean validatePhone(final String phone) {
		matcher5 = pattern5.matcher(phone);
		return matcher5.matches();
	}
	
	public boolean validateDate(final String date) {
		matcher2 = pattern2.matcher(date);
		return matcher2.matches();
	}
	
	public boolean validatePassword(final String password) {
		matcher1 = pattern1.matcher(password);
		return matcher1.matches();
	}
	public boolean validateEmail(final String email) {
		matcher3 = pattern3.matcher(email);
		return matcher3.matches();
	}
	public boolean validateUsername(final String username) {
		matcher4 = pattern4.matcher(username);
		return matcher4.matches();
	}
}
