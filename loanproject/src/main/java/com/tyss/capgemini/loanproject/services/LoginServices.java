package com.tyss.capgemini.loanproject.services;

public interface LoginServices {
	/**
	 * 
	 * @param custUsername
	 * @param password
	 * @return
	 */
	public boolean custLogin(String custUsername, String password);
	/**
	 * 
	 * @param empUsername
	 * @param empPass
	 * @return
	 */
	public boolean empLogin(String empUsername, String empPass);
	/**
	 * 
	 * @param occupation
	 * @param dob
	 * @param gender
	 * @param username
	 * @param userid
	 * @param email
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param phone
	 * @param accountBal
	 * @return
	 */
	public boolean register(String occupation, String dob, String gender, String username, String userid, String email, String password, String firstname, String lastname, long phone, double accountBal);
	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean emailExists(String email);
	/**
	 * 
	 * @param username
	 * @return
	 */
	public boolean usernameExists(String username);
}