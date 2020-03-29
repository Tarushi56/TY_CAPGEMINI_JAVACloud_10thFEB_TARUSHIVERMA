package com.tyss.capgemini.loanproject.servicesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//import com.tyss.capgemini.loanproject.exception.DateFormatMismatchException;
import com.tyss.capgemini.loanproject.exception.*;

import com.tyss.capgemini.loanproject.exception.PasswordFormatMismatchException;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;
import static com.tyss.capgemini.loanproject.repository.Repository.*;
class CustomerServiceTest {

	static {
		userTable();
	}
	
	boolean isTrue;
	@Test
	void testApplicationForm() {
		try {
		boolean isTrue=getCustomerServices().loanApplicationForm("AP01", "BNI12345", "Rajesh","Kumar", "Santoshi",
				"14/3/1973", "Rakesh","Kumar", "Panda", "Personal Loan", "BNI22343456",
				"Cannaught Circle", "09/12/1992", "23/5/2020", "submit");
		assertEquals(isTrue, true);
		}catch (DateFormatMismatchException e) {
			assertThrows(DateFormatMismatchException.class, () -> {
				getCustomerServices().loanApplicationForm("AP01", "BNI12345", "Rajesh","Kumar", "Santoshi",
						"14/3/1973", "Rakesh","Kumar", "Panda", "Personal Loan", "BNI22343456",
						"Cannaught Circle", "09/12/1992", "23/5/2020", "submit");
			});
		}catch (DateOutOfBoundException  e) {
			assertThrows(DateOutOfBoundException.class, () -> {
				getCustomerServices().loanApplicationForm("AP01", "BNI12345", "Rajesh","Kumar", "Santoshi",
						"14/3/2020", "Rakesh","Kumar", "Panda", "Personal Loan", "BNI22343456",
						"Cannaught Circle", "09/12/1992", "23/5/2020", "submit");
			});
		}
	}
	
	@Test
	void changePassword() {

		String username = "praveen191";
		String newPass = "Pass@2";
		try {
			isTrue = getCustomerServices().changePassword(username, newPass);
			assertEquals(isTrue, true);
		} catch (Exception e) {
			assertThrows(PasswordFormatMismatchException.class, () -> {
				getCustomerDAO().changePassword(username, newPass);
			});
		}
	}
	
	@Test
	void payLoan1() {
		String username = "poonam191";
		double loanPay = 50000;
		try {
			isTrue = getCustomerDAO().payLoan(username, loanPay);
			assertEquals(isTrue, true);
		} catch (LoanExcessException e) {
			assertThrows(LoanExcessException.class, () -> {
				getCustomerDAO().payLoan(username, loanPay);
			});
		} catch (InsufficientBalanceException e) {
			assertThrows(InsufficientBalanceException.class, () -> {
				getCustomerDAO().payLoan(username, loanPay);
			});
		}
	}
	
	@Test
	void payLoan2() {
		String username = "Mahim@123";
		double loanPay = 500000;
		try {
			isTrue = getCustomerDAO().payLoan(username, loanPay);
			assertEquals(isTrue, false);
		} catch (LoanExcessException e) {
			assertThrows(LoanExcessException.class, () -> {
				getCustomerDAO().payLoan(username, loanPay);
			});
		} catch (InsufficientBalanceException e) {
			assertThrows(InsufficientBalanceException.class, () -> {
				getCustomerDAO().payLoan(username, loanPay);
			});
		}
	}
}
