package com.cg.loanprocessing.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.loanprocessing.entity.LoanForm;

public interface LoanFormRepository extends JpaRepository<LoanForm, Integer> {
	@Query(value = "select DISTINCT u from LoanForm u INNER JOIN u.applicant a where u.role='ROLE_CUSTOMER' and a.applicationStatus='Requested'")
	List<LoanForm> findAllRequested();
	
	@Query("from LoanForm where email=?1 ")
	LoanForm searchByEmail(String email);
	
	@Query("from LoanForm where email=?1 and password=?2 ")
	LoanForm login(String email,String password);
	
	@Query(value = "select u from LoanForm u where role='ROLE_CUSTOMER'")
	Page<LoanForm> findAllCustomer(Pageable pageable);
}

