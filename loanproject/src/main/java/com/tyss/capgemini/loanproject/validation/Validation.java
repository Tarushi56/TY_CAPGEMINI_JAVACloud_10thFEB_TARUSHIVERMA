package com.tyss.capgemini.loanproject.validation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Validation {
	/**
	 * 
	 * @param pass
	 * @return
	 */
	public boolean passValid(String pass) {
		Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$%_@]).{6,20})");
		Matcher matcher = pattern.matcher(pass);
		return matcher.matches();
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	public boolean dateValid(String date) {
		return Pattern.matches("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$", date);
	}
	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean mailValid(String email) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher matcher = pattern.matcher(email);
		Boolean boolean2 = matcher.matches();
		return boolean2;
	}
	/**
	 * 
	 * @param username
	 * @return
	 */
	public boolean usernameValid(String username) {
		Pattern pattern = Pattern.compile("^[a-z0-9_@-]{3,15}$");
		Matcher matcher = pattern.matcher(username);
		Boolean boolean1 = matcher.matches();
		return boolean1;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean alphaNumValid(String id) {
		return Pattern.matches("[0-9a-zA-Z]*", id);
	}
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean nameValid(String name) {
		return Pattern.matches("[a-zA-Z]{3,10}", name);
	}
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean fullNameValid(String name) {
		return Pattern.matches("[a-z A-Z]{3,20}", name);
	}
	/**
	 * 
	 * @param num
	 * @return
	 */
	public boolean numMismatch(String num) {
		return Pattern.matches("[0-9]*", num);
	}
	/**
	 * 
	 * @param num
	 * @return
	 */
	public boolean numMismatch1(String num) {
		return Pattern.matches("^[0-9]{0,7}$", num);
	}
	/**
	 * 
	 * @param timeperiod
	 * @return
	 */
	public boolean timePeriodValid(String timeperiod) {
		return Pattern.matches("^0*([1-9]|[1-3][0-9]|40)$", timeperiod);
	}
		/**
		 * 
		 * @param interest
		 * @return
		 */
	public boolean doubleValid(String interest) {
		return Pattern.matches("[0-9]*[.]?[0-9]*", interest);
	}
	/**
	 * 
	 * @param phone
	 * @return
	 */
	public boolean phoneValid(String phone) {
		return Pattern.matches("[6-9][0-9]{9,9}", phone);
	}
}
