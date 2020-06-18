package com.tyss.capgemini.loanproject.services;

public interface AdminServices {
	/**
	 * 
	 * @param typechoice
	 * @param choice2
	 * @param choice3
	 * @return
	 */
	public boolean loanUpdate(String typechoice, int choice2, String choice3);
	/**
	 * 
	 * @param type
	 * @param time
	 * @param rates
	 * @return
	 */
	public boolean insertLoan(String type, String time, String rates);
	/**
	 * 
	 * @param loantype
	 * @return
	 */
	public boolean deleteLoan(String loantype);
	/**
	 * 
	 * @return
	 */
	public boolean viewLoanPrograms();
	/**
	 * 
	 * @param username
	 * @param email
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param phone
	 * @return
	 */
	public boolean addClients(String username,String email,String password,
			String firstname,String lastname,String phone);
	public boolean viewClients();
	/**
	 * 
	 * @return
	 */
	public boolean approvedForms();
	/**
	 * 
	 * @return
	 */
	public boolean rejectedForms();
	/**
	 * 
	 * @return
	 */
	public boolean requestedForms();
	/**
	 * 
	 * @return
	 */
	public boolean loanTypes();
	/**
	 * 
	 * @param k
	 * @return
	 */
	public String loanTypes(String k);
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
	/**
	 * 
	 * @param loanType
	 * @param newType
	 * @return
	 */
	public String updateType(String loanType, String newType);
	/**
	 * 
	 * @param loanType
	 * @param newTime
	 * @return
	 */
	public boolean updateTimePeriod(String loanType, String newTime);
	/**
	 * 
	 * @param loanType
	 * @param newRate
	 * @return
	 */
	public boolean updateRates(String loanType, String newRate);
	}