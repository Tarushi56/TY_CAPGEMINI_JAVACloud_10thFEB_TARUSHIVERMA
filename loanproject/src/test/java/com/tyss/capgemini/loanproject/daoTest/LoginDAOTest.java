package com.tyss.capgemini.loanproject.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;
import static com.tyss.capgemini.loanproject.repository.Repository.*;

class LoginDAOTest {
boolean isTrue;
	
	static {
		userTable();
	}
	
	@Test
	void customerLoginTest1() {
		userTable();
			Boolean isBoolean = getLoginDAO().custLogin("Mahim@123", "pass6");
			assertEquals(isBoolean, true);
	}
	
	@Test
	void customerLoginTest2() {
		
		Boolean isBoolean = getLoginDAO().custLogin("arshad", "aspas");
		assertEquals(isBoolean, false);
	}
	
	@Test
	void empLogin1() {
		
		Boolean isBoolean = getLoginDAO().empLogin("mayank191", "pass1");
		assertEquals(isBoolean, true);
	}
	
	@Test
	void empLogin2() {
		
		Boolean isBoolean = getLoginDAO().empLogin("mrunal", "pass3");
		assertEquals(isBoolean, false);
	}
	
	@Test
	void empLogin3() {
		
		Boolean isBoolean = getLoginDAO().empLogin("saswat191", "pass11");
		assertEquals(isBoolean, true);
	}
	
	@Test
	void registerTest1() {
		
		Boolean isBoolean = getLoginDAO().register("businessman", "5/10/1996", "male", "andi@123", "cus123", "andi123@gmail.com", "Qwerty@123", "Mayank", "watson", 6728192790L, 50000.0);
		assertEquals(isBoolean, true);
	}
	
	@Test
	void registerTest2() {
		
		Boolean isBoolean = getLoginDAO().register("sales person", "5/10/1996", "male", "anand@123", "cus123", "anand123@gmail.com", "Qwerty@123", "anand", "Singh", 7611093264L, 50000.0);
		assertEquals(isBoolean, true);
	}
}
