package com.tyss.capgemini.loanproject.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import com.tyss.capgemini.loanproject.exception.*;
import  static com.tyss.capgemini.loanproject.util.FactoryClass.*;
import  static com.tyss.capgemini.loanproject.repository.Repository.*;

class CustomerDAOTest {

	boolean isTrue = false;

	static {
		userTable();
	}

	@Test
	void testChangePassword1() {

		String username = "praveen191";
		String newPass = "Pass@2";
		
		isTrue = getCustomerDAO().changePassword(username, newPass);
		assertEquals(isTrue, true);
		
	}
	
	

	@Test
	void TestViewLoanPrograms() {
		List<HashMap<String, Object>> loanPrograms = getCustomerDAO().viewLoanPrograms();
		assertEquals(loanPrograms, LOANTYPE_LIST);
	}

	@Test
	void payLoan() {
		String username = "praveen191";
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
	void checkBalance() {
		String username = "shreya191";
		double balance = getCustomerDAO().checkBalance(username);
		assertEquals(balance, 60987.2);
	}

	@Test
	void checkLoan() {
		String username = "shreya191";
		double loanAmount = getCustomerDAO().checkLoan(username);
		assertEquals(loanAmount, 90700);
	}

}
