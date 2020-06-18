package com.cg.loanprocessing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.loanprocessing.dao.LoanProgramRepository;
import com.cg.loanprocessing.entity.LoanProgram;
@Service
public class LoanProgramServiceImpl implements LoanProgramService {

	private LoanProgramRepository loanProgramRepo;
	
	@Autowired
	public LoanProgramServiceImpl(LoanProgramRepository loanProgramRepo) {
	this.loanProgramRepo =loanProgramRepo;
}
	
	@Override
	public List<LoanProgram> findAllProgram() {
		return loanProgramRepo.findAll() ;
	}

	@Override
	public LoanProgram findByName(String type) {
		Optional<LoanProgram> result = loanProgramRepo.findById(type);
		LoanProgram theLoanProgram=null;
		if(result.isPresent()) {
			theLoanProgram=result.get();
			return theLoanProgram;
		}
		return null;
	}

	@Override
	public LoanProgram saveProgram(LoanProgram Program) {
		Optional<LoanProgram> result= loanProgramRepo.findById(Program.getLoanType());
		if(result.isPresent()) {
		return null;
		}else {
			return loanProgramRepo.save(Program);
		}
	}

	
	@Override
	public void deleteProgram(String type) {
		loanProgramRepo.deleteById(type);
		
	}

	@Override
	public Page<LoanProgram> getPrograms(int pageNo, int itemsPerPage) {
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage);
		return loanProgramRepo.findAll(pageable);
	}

	@Override
	public Page<LoanProgram> getSortPrograms(int pageNo, int itemsPerPage, String fieldName) {
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage, Sort.by(fieldName));
		return loanProgramRepo.findAll(pageable);
	}

	@Override
	public LoanProgram updateProgram(LoanProgram loanProgram) {
		return loanProgramRepo.save(loanProgram);
	}
}
