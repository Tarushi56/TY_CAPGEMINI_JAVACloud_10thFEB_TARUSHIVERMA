package com.cg.loanprocessing.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cg.loanprocessing.entity.LoanForm;

public interface loanFormPaginationRepository extends PagingAndSortingRepository<LoanForm, Integer> {

}
