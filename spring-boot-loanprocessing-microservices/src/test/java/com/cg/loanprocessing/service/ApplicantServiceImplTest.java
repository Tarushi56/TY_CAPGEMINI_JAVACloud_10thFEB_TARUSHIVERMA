package com.cg.loanprocessing.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.loanprocessing.dao.ApplicantRepository;
import com.cg.loanprocessing.entity.Applicant;
import com.cg.loanprocessing.entity.LoanForm;
@SpringBootTest
class ApplicantServiceImplTest {

	@Autowired
	private ApplicantService applicantService;

	Applicant applicant;
	Applicant addApplicant = null;

	@BeforeEach
	void addApplicant() {
		applicant=new Applicant();
		applicant.setApplicationStatus("Requested");
		applicant.setLoanAmount("89567");
		applicant.setLoanType("Construction");
		addApplicant=applicantService.saveApplicant(applicant);
	}
	@Test
	void testAddUser() {
		assertNotNull(addApplicant);
	}
	@Test
	void testSearchUser() {
		Applicant applicant= applicantService.getById(this.addApplicant
				.getAppId());
		assertNotNull(applicant);
	}
	
	
	@Test
	void testGetAllUsers() {
		List<Applicant> applicantList = applicantService.findAll();
		assertNotNull(applicantList);
	}
	
	
	

}
