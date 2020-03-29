package com.tyss.capgemini.loanproject.servicesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.tyss.capgemini.loanproject.exception.*;
import static  com.tyss.capgemini.loanproject.repository.Repository.*;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;
class LoginServiceTest {

	boolean isTrue;

	static {
		userTable();
	}

	@Test
	void testCustomerLogin() {
		try {
			isTrue = getLoginServices().custLogin("praveen191", "pass6");
			assertEquals(isTrue, true);
		} catch (Exception e) {
			assertThrows(InvalidCredentialsException.class, () ->{
				getLoninServices().custLogin("praveen191", "pass6");
			});
		}
	}

	@Test
	void testEmployeeLogin() {
		try {
		isTrue = getLoginServices().empLogin("mayank191", "pass1");
		assertEquals(isTrue, true);
		}catch (Exception e) {
			assertThrows(InvalidCredentialsException.class, () ->{
				getLoninServices().custLogin("mayank191", "pass1");
			});
		}
	}

	@Test
	void testRegister() {
		try {
			isTrue = getLoginServices().register("employee", "19/9/1997", "male", "sas@123", "1234", "sas@123",
					"Pass@123", "Saswata", "Biswas", 9078563421L, 89000);
			assertEquals(isTrue, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				getLoninServices().register("employee", "19/9/1997", "male", "sas@123", "1234", "sas@123", "Pass@123",
						"Saswata", "Biswas", 9078563421L, 89000);
			});
		}
	}

}
