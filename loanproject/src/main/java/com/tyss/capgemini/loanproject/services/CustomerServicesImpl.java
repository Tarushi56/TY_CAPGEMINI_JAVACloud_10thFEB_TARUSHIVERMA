package com.tyss.capgemini.loanproject.services;

import java.util.HashMap;
import java.util.List;

import static  com.tyss.capgemini.loanproject.util.FactoryClass.*;
import com.tyss.capgemini.loanproject.exception.*;
import com.tyss.capgemini.loanproject.repository.Repository;
import com.tyss.capgemini.loanproject.util.FactoryClass;
import com.tyss.capgemini.loanproject.validation.Validation;
public class CustomerServicesImpl implements CustomerServices {
	Validation validationClass = new Validation();

	@Override
	/**
	 * 
	 * @return
	 */
	public boolean viewLoanPrograms() {
		if (FactoryClass.getCustomerDao().viewLoanPrograms()) {
			return true;
		} else
			return false;
	}

	@Override
	/**
	 * 
	 * @param custUsername
	 * @param newPass
	 * @return
	 */
	public boolean changePassword(String custUsername, String newPass) {
		if (validationClass.passValid(newPass)) {
			FactoryClass.getCustomerDao().changePassword(custUsername, newPass);
			return true;
		} else {
			throw new PasswordFormatMismatchException("Password not strong enough.");
		}
	}

	@Override
	/**
	 * 
	 * @param custUsername
	 * @return
	 */
	public boolean checkBalance(String custUsername) {
		if (FactoryClass.getCustomerDao().checkBalance(custUsername)) {
			return true;
		} else
			return false;
	}

	@Override
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
			String branchName, String openDate, String requestDate, String loanAmount) {
		if (validationClass.dateValid(dateOfBirth)) {
			String[] dateOfBirthArr = dateOfBirth.split("/");
			int dobmonth = Integer.parseInt(dateOfBirthArr[1]);
			int dobyear = Integer.parseInt(dateOfBirthArr[2]);
			if ((dobmonth > 3) && (dobyear >= 2020)) {
				throw new DateFormatMismatchException("Not inside date limit.");
			} else if (validationClass.dateValid(openDate)) {
				String[] openDateArr = openDate.split("/");
				int odmonth = Integer.parseInt(openDateArr[1]);
				int odyear = Integer.parseInt(openDateArr[2]);
				if ((odmonth > 5) && (odyear >= 2020)) {
					throw new DateFormatMismatchException("Not inside date limit.");
				} else if (validationClass.dateValid(requestDate)) {
					String[] reqDateArr = requestDate.split("/");
					int rdmonth = Integer.parseInt(reqDateArr[1]);
					int rdyear = Integer.parseInt(reqDateArr[2]);
					if (((rdmonth < 5) && (rdyear < 2020)) && (rdyear > 2021)) {
						throw new DateFormatMismatchException("Not inside date limit.");
					} else
						FactoryClass.getCustomerDao().loanApplicationForm(applicationId, accountNo, email, applicantFirstName,
								applicantMiddleName, applicantLastName, dateOfBirth, coapplicantFirstName,
								coapplicantMiddleName, coapplicantLastName, loanChoice, branchCode, branchName,
								openDate, requestDate, loanAmount);
					return true;
				} else
					throw new DateFormatMismatchException("Enter correct date format (DD/MM/YYYY).");
			} else
				throw new DateFormatMismatchException("Enter correct date format (DD/MM/YYYY).");
		} else
			throw new DateFormatMismatchException("Enter correct date format (DD/MM/YYYY).");
	}

	@Override
	/**
	 * 
	 * @param custUsername
	 * @param loanPay
	 * @return
	 */
	public boolean payLoan(String custUsername, Double loanPay) {
		for (int i = 0; i < Repository.customerList.size(); i++) {
			if (custUsername.equals(Repository.customerList.get(i).get("username"))) {
				Double loan = (Double) Repository.customerList.get(i).get("loanAmount");
				if (loanPay > loan) {
					throw new LoanExcessException("Enter amount less than your loan amount.");
				}
				if (loanPay > (Double) Repository.customerList.get(i).get("AccountBal")) {
					throw new InsufficientBalanceException("Insufficient balance in account.");
				} else {
					FactoryClass.getCustomerDao().payLoan(custUsername, loanPay);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	/**
	 * 
	 * @param custUsername
	 * @return
	 */
	public boolean checkLoan(String custUsername) {
		if (FactoryClass.getCustomerDao().checkLoan(custUsername)) {
			return true;
		} else
			return false;
	}

	@Override
	/**
	 * 
	 * @return
	 */
	public boolean loanTypes() {
		if (FactoryClass.getCustomerDao().loanTypes()) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	/**
	 * 
	 * @param k
	 * @return
	 */
	public String loanTypes(int k) {
		return FactoryClass.getCustomerDao().loanTypes(k);
	}

	@Override
	/**
	 * 
	 * @param custUsername
	 * @return
	 */
	public boolean viewApplications(String custUsername) {
		FactoryClass.getCustomerDao().viewApplications(custUsername);
		return true;
	}
	
	@Override
	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean emailExists(String email) {
		return FactoryClass.getLoginDao().emailExists(email);
	}

	@Override
	/**
	 * 
	 * @param username
	 * @return
	 */
	public boolean usernameExists(String username) {
		return FactoryClass.getLoginDao().usernameExists(username);
	}
	
	@Override
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean applicationExist(String id) {
		return FactoryClass.getCustomerDao().applicationExist(id);
	}
	
	@Override
	/**
	 * 
	 * @param username
	 * @return
	 */
	public String fetchMail(String username) {
		return FactoryClass.getCustomerDao().fetchMail(username);
	}

	@Override
	/**
	 * 
	 * @param username
	 * @return
	 */
	public String fetchFirstName(String username) {
		return FactoryClass.getCustomerDao().fetchFirstName(username);
	}

	@Override
	/**
	 * 
	 * @param username
	 * @return
	 */
	public String fetchLastName(String username) {
		return FactoryClass.getCustomerDao().fetchLastName(username);
	}

	@Override
	/**
	 * 
	 * @param username
	 * @return
	 */
	public Double returnBal(String username) {
		return FactoryClass.getCustomerDao().returnBal(username);
	}
	@Override
	public String autoGenerateId() {
		return FactoryClass.getCustomerDao().autoGenerateId();
	}
	
	
}
