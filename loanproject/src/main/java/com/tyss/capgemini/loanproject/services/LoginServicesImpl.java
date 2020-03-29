package com.tyss.capgemini.loanproject.services;

import static com.tyss.capgemini.loanproject.repository.Repository.*;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;
import   com.tyss.capgemini.loanproject.exception.*;;
public class LoginServicesImpl implements LoginServices {
	@Override
	public boolean custLogin(String custUsername, String custPass) {
		int count = 0;
		for (int i = 0; i < CUSTOMER_LIST.size(); i++) {
			if ((custUsername.equals(CUSTOMER_LIST.get(i).get("username"))
					&& (custPass.equals(CUSTOMER_LIST.get(i).get("password"))))) {
				count++;
				getLoginDAO().custLogin(custUsername, custPass);
				return true;
			}
		}
		if (count == 0) {
			throw new InvalidCredentialsException("Enter correct username and password");
		}
		return false;
	}

	@Override
	public boolean empLogin(String empUsername, String empPass) {
		int count = 0;
		for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
			if ((empUsername.equals(EMPLOYEE_LIST.get(i).get("username"))
					&& (empPass.equals(EMPLOYEE_LIST.get(i).get("password"))))) {
				count++;
				getLoginDAO().empLogin(empUsername, empPass);
				return true;
			}
		}
		if (count == 0) {
			throw new InvalidCredentialsException("Enter correct username and password");
		}
		return false;
	}

	@Override
	public boolean register(String occupation, String dob, String gender, String username, String userid, String email,
			String password, String firstname, String lastname, long phone, double accountBal) {
		if (getValidation().validateUsername(username)) {
			if (getValidation().validatePassword(password)) {
				if (getValidation().validateEmail(email)) {
					if (getValidation().validateDate(dob)) {
						String[] dateOfBirthArr = dob.split("/");
						int dobmonth = Integer.parseInt(dateOfBirthArr[1]);
						int dobyear = Integer.parseInt(dateOfBirthArr[2]);
						if ((dobmonth > 3) && (dobyear >= 2002)) {
							throw new DateOutOfBoundException("Not inside date limit.");
						}
						if ((phone < 6000000000L) || (phone > 9999999999L)) {
							getLoginDAO().register(occupation, dob, gender, username, userid, email, password,
									firstname, lastname, phone, accountBal);
							return true;
						} else
							throw new InvalidPhoneNumberException("Invalid phone number");
					} else
						throw new DateFormatMismatchException("Enter correct date format (DD/MM/YYYY).");
				} else
					throw new EmailFormatMismatchException("Enter correct email format");
			} else
				throw new PasswordFormatMismatchException("Enter correct password format");
		} else
			throw new UsernameFormatMismatchException("Enter correct format");
	}
}
