package com.tyss.capgemini.loanproject.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import static com.tyss.capgemini.loanproject.repository.Repository.*;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;
class AdminDAOTest {

	static {
		userTable();
	}

	boolean isTrue;

	@Test
	void testUpdateLoan1() {
		isTrue = getAdminDAO().loanUpdate("House Loan", 1, "Home Loan");
		assertEquals(isTrue, true);
	}

	@Test
	void testUpdateLoan2() {
		isTrue = getAdminDAO().loanUpdate("Property Loan", 1, "Home Loan");
		assertEquals(isTrue, false);
	}

	@Test
	void testInsertLoan() {
		isTrue = getAdminDAO().insertLoan("Business Loan", "30 years(Max)", "8.75-11.25%");
		assertEquals(isTrue, true);
	}

	
	@Test
	void testViewClients() {
		List<HashMap<String , Object>> clients=getAdminDAO().viewClients();
		assertEquals(clients,CLIENT_LIST);
	}
	
	@Test
	void addClient1() {
		isTrue=getAdminDAO().addClients("AP01");
		assertEquals(isTrue, true);
	}
	
	@Test
	void addClient2() {
		isTrue=getAdminDAO().addClients("AP090");
		assertEquals(isTrue, false);
	}
	
	@Test
	void testApprovedForms() {
		List<HashMap<String, Object>> approved=getAdminDAO().approvedForms();
		assertEquals(approved, APPROVEDFORM_LIST);
	}
	
	@Test
	void testRejectedForms() {
		List<HashMap<String, Object>> rejected=getAdminDAO().rejectedForms();
		assertEquals(rejected , REJECTEDFORM_LIST);
	}
	
	@Test
	void testRequestedForms() {
		List<HashMap<String, Object>> requested=getAdminDAO().requestedForms();
		assertEquals(requested, REQUESTEDFORM_LIST);
	}
}
