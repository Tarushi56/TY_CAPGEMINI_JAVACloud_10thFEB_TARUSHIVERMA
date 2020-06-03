package com.cg.loanprocessing.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.loanprocessing.entity.LoanForm;
@SpringBootTest
class LoanFormServiceImplTest {

	/*
	 * @Autowired private UserRepository userRepository;
	 */
	@Autowired
	private LoanFormService loanFormService;

	LoanForm loanForm;
	LoanForm addForm = null;

	@BeforeEach
	void addUser() {
		loanForm=new LoanForm();
		loanForm.setFullName("Ashish k");
		loanForm.setEmail("ashishk@gmail.com");
		loanForm.setGender("Male");
		loanForm.setAddress("33/2 Grasim Staff Colony");
		loanForm.setRole("ROLE_CUSTOMER");
		loanForm.setAge("30");
		loanForm.setPassword("Qwerty@123");
		loanForm.setPanNumber("BNZPM2501F");
		loanForm.setMobileNumber("9009415759");
		loanForm.setLoanType("Purchase");
		loanForm.setLoanAmount("1000");
		loanForm.setSalary("58975");
		addForm=loanFormService.save(loanForm);

	}

	@Test
	void testAddUser() {
		assertNotNull(addForm);
	}

	@Test
	void testSearchUser() {
		LoanForm loanForm = loanFormService.findById(this.addForm.getLoanId());
		assertNotNull(loanForm);
	}

	@Test
	void testGetAllUsers() {
		List<LoanForm> formList = loanFormService.findAll();
		assertNotNull(formList);
	}

	@AfterEach
	void testDeleteUser() {
		loanForm = loanFormService.findById(this.addForm.getLoanId());
		loanFormService.delete(loanForm.getLoanId());
	}

	
  @Test void testAfterDelete() {
	  assertNotNull(loanForm); }
	 
}
