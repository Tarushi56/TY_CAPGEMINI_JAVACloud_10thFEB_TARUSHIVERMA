package com.cg.loanprocessing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.loanprocessing.entity.LoanProgram;

public interface LoanProgramRepository extends JpaRepository<LoanProgram, String> {

}
