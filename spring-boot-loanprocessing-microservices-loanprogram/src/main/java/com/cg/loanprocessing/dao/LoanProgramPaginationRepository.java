package com.cg.loanprocessing.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cg.loanprocessing.entity.LoanProgram;

public interface LoanProgramPaginationRepository extends PagingAndSortingRepository<LoanProgram, String> {

}
