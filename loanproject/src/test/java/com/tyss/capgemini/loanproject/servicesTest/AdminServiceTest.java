package com.tyss.capgemini.loanproject.servicesTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;
import static com.tyss.capgemini.loanproject.repository.Repository.*;
import com.tyss.capgemini.loanproject.exception.*;

class AdminServiceTest {

boolean isTrue;
	
	static {
		userTable();
	}

	@Test
	void test() {
		List<HashMap<String, Object>> isEquals = getAdminServices().viewLoanPrograms();
		assertEquals(isEquals, LOANTYPE_LIST);
	}

	@Test
	void testAddClient1() {
		try {
			isTrue = getAdminServices().addClients("AP01");
			assertEquals(isTrue, true);
		} catch (InvalidAppliactionIdException  e) {
			assertThrows(InvalidAppliactionIdException .class, () ->{
				getAdminServices().addClients("AP01");
			});
		}
	}
	
	@Test
	void testAddClient2() {
		try {
			isTrue = getAdminServices().addClients("AP90");
			assertEquals(isTrue, false);
		} catch (InvalidAppliactionIdException  e) {
			assertThrows(InvalidAppliactionIdException .class, () ->{
				getAdminServices().addClients("AP90");
			});
		}
	}
	
	@Test
	void testDeleteLoan1() {
		try {
			isTrue = getAdminServices().deleteLoan("House Loan");
			assertEquals(isTrue, true);
		} catch (InvalidLoanTypeException e) {
			assertThrows(InvalidLoanTypeException.class, () ->{
				getAdminServices().deleteLoan("House Loan");
			});
		}
	}
	
	@Test
	void testDeleteLoan2() {
		try {
			isTrue = getAdminServices().deleteLoan("Business Loan");
			assertEquals(isTrue, false);
		} catch (InvalidLoanTypeException e) {
			assertThrows(InvalidLoanTypeException.class, () ->{
				getAdminServices().deleteLoan("Buisness Loan");
			});
		}
	}

}
