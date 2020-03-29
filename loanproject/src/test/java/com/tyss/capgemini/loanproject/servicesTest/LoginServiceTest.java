package com.tyss.capgemini.loanproject.servicesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.tyss.capgemini.loanproject.exception.*;
import static com.tyss.capgemini.loanproject.repository.Repository.*;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;

class LoginServiceTest {

	boolean isTrue;

	static {
		userTable();
	}

	@Test
	void custLoginTest1() {
		try {
			Boolean isBoolean = getLoginServices().custLogin("manoj191", "pass6");
			assertEquals(isBoolean, true);
		} catch (Exception e) {

			assertThrows(InvalidCredentialsException.class, () -> {
				getLoginServices().custLogin("manoj191", "pass6");
			});
		}
	}

	@Test
	void custLoginTest2() {

		try {
			Boolean isBoolean = getLoginServices().custLogin("manojqwe191", "pass6");
			assertEquals(isBoolean, true);
		} catch (Exception e) {

			assertThrows(InvalidCredentialsException.class, () -> {
				getLoginServices().custLogin("manojqwe191", "pass6");
			});
		}
	}

	@Test
	void empLoginTest1() {

		try {
			Boolean isBoolean = getLoginServices().empLogin("mayank191", "pass1");
			assertEquals(isBoolean, true);
		} catch (Exception e) {
			assertThrows(InvalidCredentialsException.class, () -> {
				getLoginServices().empLogin("mayank191", "pass1");
			});
		}
	}

	@Test
	void empLoginTest2() {
		try {
			Boolean isBoolean = getLoginServices().empLogin("mayank191123", "pass1");
			assertEquals(isBoolean, true);
		} catch (Exception e) {
			assertThrows(InvalidCredentialsException.class, () -> {
				getLoginServices().empLogin("mayank191123", "pass1");
			});
		}
	}

	@Test
	void empLoginTest3() {

		try {
			Boolean isBoolean = getLoginServices().empLogin("saswat191", "pass11");
			assertEquals(isBoolean, true);
		} catch (Exception e) {
			assertThrows(InvalidCredentialsException.class, () -> {
				getLoginServices().empLogin("saswat191", "pass11");
			});
		}
	}

	@Test
	void registerTest1() {
		try {
			Boolean isBoolean = getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
					"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			assertEquals(isBoolean, true);
		} catch (DateOutOfBoundException e) {
			assertThrows(DateOutOfBoundException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (InvalidPhoneNumberException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (DateFormatMismatchException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (PasswordFormatMismatchException  e) {
			assertThrows(PasswordFormatMismatchException .class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (InvalidEmailFormatException e) {
			assertThrows(InvalidEmailFormatException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		}
	}

	@Test
	void registerTest2() {

		try {
			Boolean isBoolean = getLoginServices().register("businessman", "5-10-1996", "male", "Mayank123", "cus123",
					"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			assertEquals(isBoolean, true);
		} catch (DateOutOfBoundException e) {
			assertThrows(DateOutOfBoundException.class, () -> {
				getLoginServices().register("businessman", "5-10-1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (InvalidPhoneNumberException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				getLoginServices().register("businessman", "5-10-1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (DateFormatMismatchException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				getLoginServices().register("businessman", "5-10-1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (PasswordFormatMismatchException  e) {
			assertThrows(PasswordFormatMismatchException .class, () -> {
				getLoginServices().register("businessman", "5-10-1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (InvalidEmailFormatException e) {
			assertThrows(InvalidEmailFormatException.class, () -> {
				getLoginServices().register("businessman", "5-10-1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		}
	}

	@Test
	void registerTest3() {

		try {
			Boolean isBoolean = getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
					"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 76093264L, 50000.0);
			assertEquals(isBoolean, true);
		} catch (DateOutOfBoundException e) {
			assertThrows(DateOutOfBoundException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 76093264L, 50000.0);
			});
		} catch (InvalidPhoneNumberException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 76093264L, 50000.0);
			});
		} catch (DateFormatMismatchException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 76093264L, 50000.0);
			});
		} catch (PasswordFormatMismatchException  e) {
			assertThrows(PasswordFormatMismatchException .class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 76093264L, 50000.0);
			});
		} catch (InvalidEmailFormatException e) {
			assertThrows(InvalidEmailFormatException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 76093264L, 50000.0);
			});
		}
	}

	@Test
	void registerTest4() {

		try {
			Boolean isBoolean = getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
					"mayank123@gmail.com", "Qwerty123", "Mayank", "Singh", 7611093264L, 50000.0);
			assertEquals(isBoolean, true);
		} catch (DateOutOfBoundException e) {
			assertThrows(DateOutOfBoundException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		} catch (InvalidPhoneNumberException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		} catch (DateFormatMismatchException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		} catch (PasswordFormatMismatchException  e) {
			assertThrows(PasswordFormatMismatchException .class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		} catch (InvalidEmailFormatException e) {
			assertThrows(InvalidEmailFormatException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		}
	}

	@Test
	void registerTest5() {

		try {
			Boolean isBoolean = getLoginServices().register("businessman", "5/10/1996", "male", "Mayank@123", "cus123",
					"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7611093264L, 50000.0);
			assertEquals(isBoolean, true);
		} catch (DateOutOfBoundException e) {
			assertThrows(DateOutOfBoundException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank@123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		} catch (InvalidPhoneNumberException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank@123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		} catch (DateFormatMismatchException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank@123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		} catch (PasswordFormatMismatchException  e) {
			assertThrows(PasswordFormatMismatchException .class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank@123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		} catch (InvalidEmailFormatException e) {
			assertThrows(InvalidEmailFormatException.class, () -> {
				getLoginServices().register("businessman", "5/10/1996", "male", "Mayank@123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		}
	}
}
