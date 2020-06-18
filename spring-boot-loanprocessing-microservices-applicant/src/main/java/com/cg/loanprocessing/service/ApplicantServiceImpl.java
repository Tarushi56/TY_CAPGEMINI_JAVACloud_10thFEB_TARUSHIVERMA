package com.cg.loanprocessing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loanprocessing.dao.ApplicantRepository;
import com.cg.loanprocessing.entity.Applicant;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Override
	public Applicant saveApplicant(Applicant applicant) {
		return applicantRepository.save(applicant);
	}

	@Override
	public Applicant getById(int id) {
		Optional<Applicant> result=applicantRepository.findById(id);
		Applicant applicant =null;
		if (result.isPresent()) {
			applicant=result.get();
		} else {
throw new RuntimeException("Id not found "+id );
		}return applicant;
	}

	@Override
	public List<Applicant> findAll() {
		return applicantRepository.findAllRequested();
	}

	@Override
	public Applicant setApproved(int id) {
		Optional<Applicant> result = applicantRepository.findById(id);
		Applicant applicant = null;
		applicant = result.get();
		applicant.setApplicationStatus("Approved");
		applicantRepository.save(applicant);
		return applicant;
	}

	@Override
	public Applicant setRejected(int id) {
		Optional<Applicant> result = applicantRepository.findById(id);
		Applicant applicant = null;
		applicant = result.get();
		applicant.setApplicationStatus("Rejected");
		applicantRepository.save(applicant);
		return applicant;
	}

}
