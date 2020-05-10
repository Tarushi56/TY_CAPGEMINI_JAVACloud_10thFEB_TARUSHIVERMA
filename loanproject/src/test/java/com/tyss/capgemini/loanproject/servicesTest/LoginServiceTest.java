package com.tyss.capgemini.loanproject.servicesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.tyss.capgemini.loanproject.exception.DateFormatMismatchException;
import com.tyss.capgemini.loanproject.exception.DateLimitException;
import com.tyss.capgemini.loanproject.exception.InvalidCredentialsException;
import com.tyss.capgemini.loanproject.exception.InvalidEmailFormatException;
import com.tyss.capgemini.loanproject.exception.InvalidPhoneNumberException;
import com.tyss.capgemini.loanproject.exception.PasswordFormatMismatchException;
import com.tyss.capgemini.loanproject.repository.Repository;
import com.tyss.capgemini.loanproject.services.LoginServicesImpl;

class LoginServiceTest {

	LoginServicesImpl implementation = new LoginServicesImpl();

	@Test
	void custLoginTest1() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.custLogin("manoj191", "pass6");
			assertEquals(isBoolean, true);
		} catch (Exception e) {

			assertThrows(InvalidCredentialsException.class, () -> {
				implementation.custLogin("manoj191", "pass6");
			});
		}
	}

	@Test
	void custLoginTest2() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.custLogin("manojqwe191", "pass6");
			assertEquals(isBoolean, true);
		} catch (Exception e) {

			assertThrows(InvalidCredentialsException.class, () -> {
				implementation.custLogin("manojqwe191", "pass6");
			});
		}
	}

	@Test
	void empLoginTest1() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.empLogin("mayank191", "pass1");
			assertEquals(isBoolean, true);
		} catch (Exception e) {
			assertThrows(InvalidCredentialsException.class, () -> {
				implementation.empLogin("mayank191", "pass1");
			});
		}
	}

	@Test
	void empLoginTest2() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.empLogin("mayank191123", "pass1");
			assertEquals(isBoolean, true);
		} catch (Exception e) {
			assertThrows(InvalidCredentialsException.class, () -> {
				implementation.empLogin("mayank191123", "pass1");
			});
		}
	}

	@Test
	void empLoginTest3() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.empLogin("saswat191", "pass11");
			assertEquals(isBoolean, true);
		} catch (Exception e) {
			assertThrows(InvalidCredentialsException.class, () -> {
				implementation.empLogin("saswat191", "pass11");
			});
		}
	}

	@Test
	void registerTest1() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
					"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			assertEquals(isBoolean, true);
		} catch (DateLimitException e) {
			assertThrows(DateLimitException.class, () -> {
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (InvalidPhoneNumberException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (DateFormatMismatchException  e) {
			assertThrows(DateFormatMismatchException.class, ()->{
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123", "mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (PasswordFormatMismatchException e) {
			assertThrows(PasswordFormatMismatchException.class, ()->{
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123", "mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (InvalidEmailFormatException e) {
			assertThrows(InvalidEmailFormatException.class, ()->{
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123", "mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		}
	}

	@Test
	void registerTest2() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.register("businessman", "5-10-1996", "male", "Mayank123", "cus123",
					"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			assertEquals(isBoolean, true);
		} catch (DateLimitException e) {
			assertThrows(DateLimitException.class, () -> {
				implementation.register("businessman", "5-10-1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (InvalidPhoneNumberException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				implementation.register("businessman", "5-10-1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (DateFormatMismatchException e) {
			assertThrows(DateFormatMismatchException.class, ()->{
				implementation.register("businessman", "5-10-1996", "male", "Mayank123", "cus123", "mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (PasswordFormatMismatchException e) {
			assertThrows(PasswordFormatMismatchException.class, ()->{
				implementation.register("businessman", "5-10-1996", "male", "Mayank123", "cus123", "mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		} catch (InvalidEmailFormatException e) {
			assertThrows(InvalidEmailFormatException.class, ()->{
				implementation.register("businessman", "5-10-1996", "male", "Mayank123", "cus123", "mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 7681093264L, 50000.0);
			});
		}
	}
	
	@Test
	void registerTest3() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
					"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 76093264L, 50000.0);
			assertEquals(isBoolean, true);
		} catch (DateLimitException e) {
			assertThrows(DateLimitException.class, () -> {
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 76093264L, 50000.0);
			});
		} catch (InvalidPhoneNumberException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 76093264L, 50000.0);
			});
		} catch (DateFormatMismatchException e) {
			assertThrows(DateFormatMismatchException.class, ()->{
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123", "mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 76093264L, 50000.0);
			});
		} catch (PasswordFormatMismatchException e) {
			assertThrows(PasswordFormatMismatchException.class, ()->{
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123", "mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 76093264L, 50000.0);
			});
		} catch (InvalidEmailFormatException e) {
			assertThrows(InvalidEmailFormatException.class, ()->{
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123", "mayank123@gmail.com", "Qwerty@123", "Mayank", "Singh", 76093264L, 50000.0);
			});
		}
	}
	
	@Test
	void registerTest4() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
					"mayank123@gmail.com", "Qwerty123", "Mayank", "Singh", 7611093264L, 50000.0);
			assertEquals(isBoolean, true);
		} catch (DateLimitException e) {
			assertThrows(DateLimitException.class, () -> {
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		} catch (InvalidPhoneNumberException e) {
			assertThrows(InvalidPhoneNumberException.class, () -> {
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123",
						"mayank123@gmail.com", "Qwerty123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		} catch (DateFormatMismatchException e) {
			assertThrows(DateFormatMismatchException.class, ()->{
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123", "mayank123@gmail.com", "Qwerty123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		} catch (PasswordFormatMismatchException e) {
			assertThrows(PasswordFormatMismatchException.class, ()->{
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123", "mayank123@gmail.com", "Qwerty123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		} catch (InvalidEmailFormatException e) {
			assertThrows(InvalidEmailFormatException.class, ()->{
				implementation.register("businessman", "5/10/1996", "male", "Mayank123", "cus123", "mayank123@gmail.com", "Qwerty123", "Mayank", "Singh", 7611093264L, 50000.0);
			});
		}
	}
}
