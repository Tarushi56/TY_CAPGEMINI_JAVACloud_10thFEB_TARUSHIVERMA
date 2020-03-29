package com.tyss.capgemini.loanproject.servicesTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;
import static com.tyss.capgemini.loanproject.repository.Repository.*;
import static com.tyss.capgemini.loanproject.dao.LadDAOImpl.*;
class LADServiceTest {


	boolean isTrue;
	
	static {
		userTable();
	}
	
	  @Test 
	  void testViewLoanPrograms(){
		  List<HashMap<String , Object>> loanPrograms=getLadServices().viewLoanPrograms(); 
		  assertEquals(loanPrograms, LOANTYPE_LIST); }
	  		
	
	@Test
	void testLadReviewForms(){
		isTrue=getLadServices().ladReviewForms("AP03", "requested");
		assertEquals(isTrue, true);
	}
	
	@Test
	void testLadViewForms(){
		List<HashMap<String , Object>> loanForms=getLadServices().ladViewForms("House Loan");
		assertEquals(loanForms, FORMS);
	}
	
	
	  @Test 
	  void testRequestedForms(){
		List<HashMap<String , Object>> isEquals=getLadServices().requestedForms();
		assertEquals(isEquals, REQUESTED_FORMS); 
	  }

}
