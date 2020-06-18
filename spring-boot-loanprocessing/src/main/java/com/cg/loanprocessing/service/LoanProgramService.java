package com.cg.loanprocessing.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.loanprocessing.entity.LoanProgram;

public interface LoanProgramService {
	public List<LoanProgram> findAllProgram();

	public LoanProgram findByName(String type);

	public LoanProgram saveProgram(LoanProgram loanProgram);

	public void deleteProgram(String type);
	
	public LoanProgram updateProgram(LoanProgram loanProgram);

	public Page<LoanProgram> getPrograms(int pageNo, int itemsPerPage);

	public Page<LoanProgram> getSortPrograms(int pageNo, int itemsPerPage, String fieldName);
}
