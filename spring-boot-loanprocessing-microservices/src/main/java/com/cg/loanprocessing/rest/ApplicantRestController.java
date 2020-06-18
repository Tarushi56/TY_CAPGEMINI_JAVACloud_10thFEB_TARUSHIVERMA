package com.cg.loanprocessing.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.loanprocessing.entity.Applicant;
import com.cg.loanprocessing.entity.LoanForm;
import com.cg.loanprocessing.exception.ApplicationNotFoundException;
import com.cg.loanprocessing.response.Response;
import com.cg.loanprocessing.service.ApplicantService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApplicantRestController {
	@Autowired
	private RestTemplate template;
	@Autowired
	private ApplicantService applicantService;

	@SuppressWarnings("unchecked")
	@GetMapping("/loanapplication")
	public List<Applicant> findAllRequested() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange(" http://localhost:8084/loanapplication", HttpMethod.GET, entity, List.class).getBody();

	}

//	@SuppressWarnings("unchecked")
//	@PutMapping("/loanapplicationapprove/{appId}")
//	public Response<Applicant> findAllApproved(@PathVariable Integer appId) {
//		Applicant result = applicantService.setApproved(appId);
//		HttpHeaders headers = new HttpHeaders();
//	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	      HttpEntity<LoanForm> entity = new HttpEntity<LoanForm>(form,headers);
//	      
//	      return template.exchange(
//	         "http://localhost:8081/loanapplicationapprove/" +appId, HttpMethod.PUT, entity, Response.class).getBody();
//	  
	//}

//	@SuppressWarnings("unchecked")
//	@PutMapping("/loanapplicationreject/{appId}")
//	public Response<Applicant> findAllRejected(@PathVariable Integer appId) {
//		Applicant result = applicantService.setRejected(appId);
//		HttpHeaders headers = new HttpHeaders();
//	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	      HttpEntity<Applicant> entity = new HttpEntity<Applicant>(appId,headers);
//	      
//	      return template.exchange(
//	         "http://localhost:8084/loanapplicationreject/"+appId, HttpMethod.PUT, entity, Response.class).getBody();
//	
//	}

	@SuppressWarnings("unchecked")
	@GetMapping("/loanapplication/{loanapplication}")
	public Response<Applicant> getById(@PathVariable int loanapplication) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange(" http://localhost:8084/loanapplication/"+loanapplication, HttpMethod.GET, entity, Response.class).getBody();

	}

	@SuppressWarnings("unchecked")
	@PostMapping("/loanapplication")
	public Response<Applicant> saveApplicant(@RequestBody Applicant applicant) {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Applicant> entity = new HttpEntity<Applicant>(applicant,headers);
	      
	      return template.exchange(
	         "http://localhost:8084/loanapplication", HttpMethod.POST, entity, Response.class).getBody();
	  
	}
//register k liye bhhi ye kaam kerga bss tble me email pwd role add karns h
	@SuppressWarnings("unchecked")
	@PutMapping("/loanapplication")
	public Response<Applicant> updateApplicant(@RequestBody Applicant applicant) {
		applicantService.saveApplicant(applicant);
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Applicant> entity = new HttpEntity<Applicant>(applicant,headers);
	      
	      return template.exchange(
	         "http://localhost:8084/loanapplication", HttpMethod.PUT, entity, Response.class).getBody();
	  
	}
}
