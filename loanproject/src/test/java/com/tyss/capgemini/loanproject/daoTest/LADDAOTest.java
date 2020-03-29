package com.tyss.capgemini.loanproject.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import static com.tyss.capgemini.loanproject.repository.Repository.*;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;
import org.junit.jupiter.api.Test;

class LADDAOTest {
	boolean isTrue;

	@Test
	void testViewLoanPrograms() {
		List<HashMap<String, Object>> loanPrograms = getLadDAO().viewLoanPrograms();
		assertEquals(loanPrograms, LOANTYPE_LIST);
	}

	@Test
	void testLadReviewForms() {
		isTrue = getLadDAO().ladReviewForms("AP03", "requested");
		assertEquals(isTrue, false);
	}

	@Test
	void testLadViewForms() {
		List<HashMap<String, Object>> loanForms = getLadDAO().ladViewForms("Vehicle Loan");
		assertEquals(loanForms, FORMS);
	}

}
