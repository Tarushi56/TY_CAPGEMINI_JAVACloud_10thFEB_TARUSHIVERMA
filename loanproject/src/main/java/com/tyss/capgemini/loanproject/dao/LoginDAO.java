package com.tyss.capgemini.loanproject.dao;

public interface LoginDAO {
	public boolean custLogin(String custUsername, String password);

	public boolean empLogin(String empUsername, String empPass);

	public boolean register(String occupation, String dob, String gender, String username, String userid, String email,
			String password, String firstname, String lastname, long phone, double accountBal);

}
