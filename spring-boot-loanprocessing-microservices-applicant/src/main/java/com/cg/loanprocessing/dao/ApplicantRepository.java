package com.cg.loanprocessing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.loanprocessing.entity.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
	@Query(value = "select a from Applicant a where applicationStatus = 'Requested'")
	List<Applicant> findAllRequested();
	
	@Query(value = "select a from Applicant a where applicationStatus = 'Approved'")
	List<Applicant> findAllApproved();
	
	@Query(value = "select a from Applicant a where applicationStatus = 'Rejected'")
	List<Applicant> findAllRejected();
}
