package com.tyss.capgemini.loanproject.services;

import java.util.HashMap;
import java.util.List;

import static  com.tyss.capgemini.loanproject.util.FactoryClass.*;
import com.tyss.capgemini.loanproject.exception.*;
public class CustomerServicesImpl implements CustomerServices {
	@Override
	public List<HashMap<String, Object>> viewLoanPrograms() {
		return getCustomerDAO().viewLoanPrograms();
	}

	@Override
	public boolean changePassword(String custUsername, String newPass) {
		if (getValidation().validatePassword(newPass)) {
			getCustomerDAO().changePassword(custUsername, newPass);
			return true;
		} else {
			throw new PasswordFormatMismatchException("password pattern doesn't match!!!");
		}

	}

	@Override
	public double checkBalance(String custUsername) {
		return getCustomerDAO().checkBalance(custUsername);
	}

	@Override
	public boolean loanApplicationForm(String applicationId, String accountNo, String applicantFirstName,
			String applicantMiddleName, String applicantLastName, String dateOfBirth, String coapplicantFirstName,
			String coapplicantMiddleName, String coapplicantLastName, String loanChoice, String branchCode,
			String branchName, String openDate, String requestDate, String sub) {
		if (getValidation().validateDate(dateOfBirth)) {
			String[] dateOfBirthArr = dateOfBirth.split("/");
			int dobmonth = Integer.parseInt(dateOfBirthArr[1]);
			int dobyear = Integer.parseInt(dateOfBirthArr[2]);
			if ((dobmonth > 3) && (dobyear >= 2020)) {
				throw new DateOutOfBoundException("Not inside date limit.");
			} else if (getValidation().validateDate(openDate)) {
				String[] openDateArr = openDate.split("/");
				int odmonth = Integer.parseInt(openDateArr[1]);
				int odyear = Integer.parseInt(openDateArr[2]);
				if ((odmonth > 3) && (odyear >= 2020)) {
					throw new DateOutOfBoundException("Not inside date limit.");
				} else if (getValidation().validateDate(requestDate)) {
					String[] reqDateArr = requestDate.split("/");
					int rdmonth = Integer.parseInt(reqDateArr[1]);
					int rdyear = Integer.parseInt(reqDateArr[2]);
					if (((rdmonth < 3) && (rdyear < 2020)) && (rdyear > 2021)) {
						throw new DateOutOfBoundException("Not inside date limit.");
					} else
						getCustomerDAO().loanApplicationForm(applicationId, accountNo, applicantFirstName,
								applicantMiddleName, applicantLastName, dateOfBirth, coapplicantFirstName,
								coapplicantMiddleName, coapplicantLastName, loanChoice, branchCode, branchName,
								openDate, requestDate, sub);
				} else
					throw new DateFormatMismatchException("Enter correct date format (DD/MM/YYYY).");
			} else
				throw new DateFormatMismatchException("Enter correct date format (DD/MM/YYYY).");
		} else
			throw new DateFormatMismatchException("Enter correct date format (DD/MM/YYYY).");
		return true;
	}

	@Override
	public boolean payLoan(String custUsername, Double loanPay) {
		return getCustomerDAO().payLoan(custUsername, loanPay);
	}

	@Override
	public double checkLoan(String custUsername) {
		return getCustomerDAO().checkLoan(custUsername);
	}
}
