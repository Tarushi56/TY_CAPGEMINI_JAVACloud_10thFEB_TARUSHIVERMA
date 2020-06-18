package com.cg.loanprocessing.service;
//galat
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.loanprocessing.dao.LoanFormRepository;
import com.cg.loanprocessing.entity.LoanForm;

@Service
public class LoanFormServiceImpl implements LoanFormService {
	private LoanFormRepository loanFormRepo;

	public LoanFormServiceImpl(LoanFormRepository loanFormRepo) {
		this.loanFormRepo = loanFormRepo;
	}
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<LoanForm> findAll() {
		return loanFormRepo.findAllRequested();
	}

	@Override
	public LoanForm findById(int id) {
		Optional<LoanForm> result = loanFormRepo.findById(id);
		LoanForm theApplication = null;
		if (result.isPresent()) {
			theApplication = result.get();
			return theApplication;
		}
		return null;
	}

	@Override
	public LoanForm save(LoanForm application) {
		application.setPassword(passwordEncoder.encode(application.getPassword()));
		return loanFormRepo.save(application);
	}

	@Override
	public void delete(int id) {
		loanFormRepo.deleteById(id);
	}

	@Override
	public Page<LoanForm> getForms(int pageNo, int itemsPerPage) {
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage);
		return loanFormRepo.findAll(pageable);
	}

	@Override
	public Page<LoanForm> getSortForms(int pageNo, int itemsPerPage, String fieldName) {
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage, Sort.by(fieldName));
		return loanFormRepo.findAll(pageable);
	}
	@Override
	public LoanForm searchByEmail(String email) {
		return loanFormRepo.searchByEmail(email) ;
	}

	@Override
	public LoanForm login(String email, String password) {
		return loanFormRepo.login(email, password);
	}

	@Override
	public Page<LoanForm> findAllCustomer(int pageNo, int itemsPerPage) {
		Pageable pageable = PageRequest.of(pageNo , itemsPerPage);
		return loanFormRepo.findAllCustomer(pageable);
	}

	@Override
	public Page<LoanForm> findAllSortedCustomer(int pageNo, int itemsPerPage, String fieldName) {
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage, Sort.by(fieldName));
		return loanFormRepo.findAllCustomer(pageable);
	}
}