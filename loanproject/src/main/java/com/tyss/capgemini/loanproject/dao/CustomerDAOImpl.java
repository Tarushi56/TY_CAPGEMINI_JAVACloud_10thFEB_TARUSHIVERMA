package com.tyss.capgemini.loanproject.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tyss.capgemini.loanproject.exception.InsufficientBalanceException;
import com.tyss.capgemini.loanproject.exception.LoanExcessException;

import static com.tyss.capgemini.loanproject.repository.Repository.*;

public class CustomerDAOImpl implements CustomerDAO {
	Logger logger = LogManager.getLogger(CustomerDAOImpl.class);

	@Override
	public List<HashMap<String, Object>> viewLoanPrograms() {
		return LOANTYPE_LIST;
	}

	@Override
	public boolean loanApplicationForm(String applicationId, String accountNo, String applicantFirstName,
			String applicantMiddleName, String applicantLastName, String dateOfBirth, String coapplicantFirstName,
			String coapplicantMiddleName, String coapplicantLastName, String loanChoice, String branchCode,
			String branchName, String openDate, String requestDate, String sub) {

		HashMap<String, Object> loanHashMap = new LinkedHashMap<String, Object>();
		loanHashMap.put("ApplicationId", applicationId);
		loanHashMap.put("AccountNo", accountNo);
		loanHashMap.put("ApplicantName", applicantFirstName + " " + applicantMiddleName + " " + applicantLastName);
		loanHashMap.put("CoapplicantName",
				coapplicantFirstName + " " + coapplicantMiddleName + " " + coapplicantLastName);
		loanHashMap.put("DateOfBirth", dateOfBirth);
		loanHashMap.put("LoanType", loanChoice);
		loanHashMap.put("BranchCode", branchCode);
		loanHashMap.put("BranchName", branchName);
		loanHashMap.put("OpenDate", openDate);
		loanHashMap.put("RequestDate", requestDate);
		loanHashMap.put("LoanStatus", "requested");
		switch (sub.toLowerCase()) {
		case "submit":
			LOANFORM_LIST.add(loanHashMap);
			logger.info("Your loan application form has been submitted successfully.");
			return true;
		case "cancel":
			logger.info("Cancelled");
			return true;
		default:
			logger.info("Invalid option");
			return false;
		}
	}

	@Override
	public boolean changePassword(String custUsername, String newPass) {
		for (int j = 0; j < CUSTOMER_LIST.size(); j++) {
			if (custUsername.equals(CUSTOMER_LIST.get(j).get("username"))) {
				CUSTOMER_LIST.get(j).put("password", newPass);
				logger.info("Password has been changed successfully.");
				return true;
			}
		}
		return false;
	}

	@Override
	public double checkBalance(String custUsername) {
		for (int i = 0; i < CUSTOMER_LIST.size(); i++) {
			if (custUsername.equals(CUSTOMER_LIST.get(i).get("username"))) {
				return (double) CUSTOMER_LIST.get(i).get("AccountBal");
			}
		}
		return 0.0;
	}

	@Override
	public boolean payLoan(String custUsername, Double loanPay) {
		for (int i = 0; i < CUSTOMER_LIST.size(); i++) {
			if (custUsername.equals(CUSTOMER_LIST.get(i).get("username"))) {
				Double loan = (Double) CUSTOMER_LIST.get(i).get("loanAmount");// 60890
				if (loanPay > loan) {
					throw new LoanExcessException("Enter amount less than your loan amount.");
				}
				Double bal = (Double) CUSTOMER_LIST.get(i).get("AccountBal");
				if (loanPay > (Double) CUSTOMER_LIST.get(i).get("AccountBal")) {
					throw new InsufficientBalanceException("Insufficient balance in account.");
				} else {
					logger.info("Amount paid successfully");
					Double newbal = bal - loanPay;
					Double newloan = loan - loanPay;
					CUSTOMER_LIST.get(i).put("AccountBal", newbal);
					CUSTOMER_LIST.get(i).put("loanAmount", newloan);
					return true;
				}
			}

		}
		return false;
	}

	@Override
	public double checkLoan(String custUsername) {
		for (int i = 0; i < CUSTOMER_LIST.size(); i++) {
			if (custUsername.equals(CUSTOMER_LIST.get(i).get("username"))) {
				return (double) CUSTOMER_LIST.get(i).get("loanAmount");
			}
		}
		return 0.0;
	}
}
