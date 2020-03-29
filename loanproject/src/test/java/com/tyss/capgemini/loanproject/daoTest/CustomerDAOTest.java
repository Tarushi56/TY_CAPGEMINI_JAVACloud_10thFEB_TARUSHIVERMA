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
	void payLoan1() {
		isTrue=getCustomerDAO().payLoan("poonam191", 12000.0);
		assertEquals(isTrue, true);
	}
	
	
	
	@Test
	void testChangePassword1() {

		String username = "poonam191";
		String newPass = "Pass@6343";
		
		isTrue = getCustomerDAO().changePassword(username, newPass);
		assertEquals(isTrue, true);
		
	}
	
	void testChangePassword2() {

		String username = "Aldred";
		String newPass = "pass";
		
		isTrue = getCustomerDAO().changePassword(username, newPass);
		assertEquals(isTrue, false);
		
	}


	@Test
	void TestViewLoanPrograms() {
		List<HashMap<String, Object>> loanPrograms = getCustomerDAO().viewLoanPrograms();
		assertEquals(loanPrograms, LOANTYPE_LIST);
	}

	

	@Test
	void checkBalance1() {
		String username = "shreya191";
		double balance = getCustomerDAO().checkBalance(username);
		assertEquals(balance, 60987.2);
	}
	
	@Test
	void checkBalance2() {
		String username = "ranjan@123";
		double balance = getCustomerDAO().checkBalance(username);
		assertEquals(balance, 0.0);
	}
	
	
	@Test
	void checkLoan1() {
		String username = "shreya191";
		double loanAmount = getCustomerDAO().checkLoan(username);
		assertEquals(loanAmount, 90700);
	}
	
	@Test
	void checkLoan2() {
		String username = "shresh30";
		double loanAmount = getCustomerDAO().checkLoan(username);
		assertEquals(loanAmount, 0.0);
	}

}
