package com.tyss.capgemini.loanproject.services;

import java.util.HashMap;
import java.util.List;

public interface CustomerServices {
	public List<HashMap<String, Object>> viewLoanPrograms();

	public boolean changePassword(String custUsername, String newPass);

	public double checkBalance(String custUsername);

	public boolean loanApplicationForm(String applicationId, String accountNo, String applicantFirstName,
			String applicantMiddleName, String applicantLastName, String dateOfBirth, String coapplicantFirstName,
			String coapplicantMiddleName, String coapplicantLastName, String loanChoice, String branchCode,
			String branchName, String openDate, String requestDate, String sub);

	public boolean payLoan(String custUsername, Double loanPay);

	public double checkLoan(String custUsername);
}
