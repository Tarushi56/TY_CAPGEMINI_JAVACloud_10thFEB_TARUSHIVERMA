package com.tyss.capgemini.loanproject.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;
import static com.tyss.capgemini.loanproject.repository.Repository.*;

class LoginDAOTest {
	boolean isTrue = false;

	static {
		userTable();
	}

	@Test
	void testCudtomerDAOLogin() {
		isTrue = getLoginDAO().custLogin("praveen191", "pass6");
		assertEquals(isTrue, true);
	}

}
