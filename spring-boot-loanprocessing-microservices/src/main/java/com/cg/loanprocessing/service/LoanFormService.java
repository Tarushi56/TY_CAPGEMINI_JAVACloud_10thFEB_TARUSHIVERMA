package com.cg.loanprocessing.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.loanprocessing.entity.LoanForm;

public interface LoanFormService {
	public List<LoanForm> findAll();

	public LoanForm findById(int id);

	public LoanForm save(LoanForm application);

	public void delete(int id);

	public Page<LoanForm> getForms(int pageNo , int itemsPerPage);
	
	public Page<LoanForm> getSortForms(int pageNo , int itemsPerPage, String fieldName);
	
	public LoanForm searchByEmail(String email);
	
	public LoanForm login(String email, String password);

public Page<LoanForm> findAllCustomer(int pageNo , int itemsPerPage); // new 
	
	public Page<LoanForm> findAllSortedCustomer(int pageNo , int itemsPerPage , String fieldName);
}
