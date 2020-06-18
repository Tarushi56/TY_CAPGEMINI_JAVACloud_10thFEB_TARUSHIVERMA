package com.tyss.capgemini.loanproject.services;

public interface CustomerServices {
	/**
	 * 
	 * @return
	 */
	public boolean viewLoanPrograms();
	/**
	 * 
	 * @param custUsername
	 * @param newPass
	 * @return
	 */
	public boolean changePassword(String custUsername, String newPass);
	/**
	 * 
	 * @param custUsername
	 * @return
	 */
	public boolean checkBalance(String custUsername);
	/**
	 * 
	 * @param applicationId
	 * @param accountNo
	 * @param email
	 * @param applicantFirstName
	 * @param applicantMiddleName
	 * @param applicantLastName
	 * @param dateOfBirth
	 * @param coapplicantFirstName
	 * @param coapplicantMiddleName
	 * @param coapplicantLastName
	 * @param loanChoice
	 * @param branchCode
	 * @param branchName
	 * @param openDate
	 * @param requestDate
	 * @param loanAmount
	 * @return
	 */
	public boolean loanApplicationForm(String applicationId, String accountNo, String email, String applicantFirstName,
			String applicantMiddleName, String applicantLastName, String dateOfBirth, String coapplicantFirstName,
			String coapplicantMiddleName, String coapplicantLastName, String loanChoice, String branchCode,
			String branchName, String openDate, String requestDate, String loanAmount);
	/**
	 * 
	 * @param custUsername
	 * @param loanPay
	 * @return
	 */
	public boolean payLoan(String custUsername, Double loanPay);
	/**
	 * 
	 * @param custUsername
	 * @return
	 */
	public boolean checkLoan(String custUsername);
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
	public String loanTypes(int k);
	/**
	 * 
	 * @param custUsername
	 * @return
	 */
	public boolean viewApplications(String custUsername);
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
	 * @param id
	 * @return
	 */
	public boolean applicationExist(String id);
	/**
	 * 
	 * @param username
	 * @return
	 */
	public String fetchMail(String username);
	/**
	 * 
	 * @param username
	 * @return
	 */
	public String fetchFirstName(String username);
	/**
	 * 
	 * @param username
	 * @return
	 */
	public String fetchLastName(String username);
	/**
	 * 
	 * @param username
	 * @return
	 */
	public Double returnBal(String username);
	public String autoGenerateId();	

}