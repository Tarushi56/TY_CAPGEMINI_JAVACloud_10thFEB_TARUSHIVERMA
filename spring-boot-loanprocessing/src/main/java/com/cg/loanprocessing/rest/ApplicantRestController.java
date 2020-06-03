package com.cg.loanprocessing.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loanprocessing.entity.Applicant;
import com.cg.loanprocessing.exception.ApplicationNotFoundException;
import com.cg.loanprocessing.response.Response;
import com.cg.loanprocessing.service.ApplicantService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApplicantRestController {
	@Autowired
	private ApplicantService applicantService;

	@GetMapping("/loanapplication")
	public List<Applicant> findAllRequested() {
		return applicantService.findAll();
	}

	@PutMapping("/loanapplicationapprove/{appId}")
	public Response<Applicant> findAllApproved(@PathVariable Integer appId) {
		Applicant result = applicantService.setApproved(appId);
		if (result == null) {
			return new Response<>(true, "Updation failed", null);
		} else {
			return new Response<>(false, "successfully updated", result);
		}
//		return applicantService.setApproved(appId);
	}

	@PutMapping("/loanapplicationreject/{appId}")
	public Response<Applicant> findAllRejected(@PathVariable Integer appId) {
		Applicant result = applicantService.setRejected(appId);
		if (result == null) {
			return new Response<>(true, "Updation failed", null);
		} else {
			return new Response<>(false, "successfully updated", result);
		}
	}

	@GetMapping("/loanapplication/{loanapplication}")
	public Applicant getById(@PathVariable int loanapplication) {

		Applicant applicant = applicantService.getById(loanapplication);

		if (applicant == null) {
			throw new ApplicationNotFoundException("id not found " + loanapplication);
		}
		return applicant;
	}

	@PostMapping("/loanapplication")
	public Response<Applicant> saveApplicant(@RequestBody Applicant applicant) {
		applicant.setAppId(0);
		Applicant result = applicantService.saveApplicant(applicant);
		if (result == null) {
			return new Response<>(true, "save failed", null);
		} else {
			return new Response<>(false, "successfully saved", result);
		}
	}
//register k liye bhhi ye kaam kerga bss tble me email pwd role add karns h
	@PutMapping("/loanapplication")
	public Applicant updateApplicant(@RequestBody Applicant applicant) {
		applicantService.saveApplicant(applicant);
		return applicant;
	}
}
