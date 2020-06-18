package com.cg.loanprocessing.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.loanprocessing.entity.LoanProgram;
@SpringBootTest
class LoanProgramServiceImplTest {
	LoanProgram loanProgram;
	LoanProgram addLoan=null;
	
	@Autowired
	private LoanProgramService loanServices;
	
	@BeforeEach
	void addProgram() {
		loanProgram = new LoanProgram();
		loanProgram.setInterestRate("9");
		loanProgram.setLoanType("Purchase");
		loanProgram.setPeriod("13");
		loanProgram.setAge("25");
		addLoan = loanServices.saveProgram(loanProgram);
	}
	
	@Test
	void testSaveProgram() {
		assertEquals(true, addLoan);
	}
	
	@Test
	void testGetById() {
		LoanProgram loanPrograms2=loanServices.findByName(this.loanProgram.getLoanType());
		assertNotNull(loanPrograms2);
	}
	
	@Test
	void testFindAll() {
		List<LoanProgram> loanList=loanServices.findAllProgram();
		assertNotNull(loanList);
	}
	
	@AfterEach
	void testDeleteProgram() {
		loanServices.deleteProgram(this.loanProgram.getLoanType());
	}
	

}
