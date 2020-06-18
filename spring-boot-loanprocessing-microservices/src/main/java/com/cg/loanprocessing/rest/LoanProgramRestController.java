package com.cg.loanprocessing.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.loanprocessing.entity.LoanForm;
import com.cg.loanprocessing.entity.LoanProgram;
import com.cg.loanprocessing.exception.LoanProgramNotFoundException;
import com.cg.loanprocessing.response.Response;
import com.cg.loanprocessing.service.LoanProgramService;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class LoanProgramRestController {
	@Autowired
	private RestTemplate template;
@Autowired
	private LoanProgramService loanProgramService;

	@Autowired
	public LoanProgramRestController(LoanProgramService loanProgramService) {
		this.loanProgramService = loanProgramService;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/loan")
	public List<LoanProgram> findAllProgram() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange("http://localhost:8082/api/loan", HttpMethod.GET, entity, List.class).getBody();

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/loan/{type}")
	public Response<LoanProgram> getLoan(@PathVariable String type) {
		LoanProgram program = loanProgramService.findByName(type);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange("http://localhost:8082/api/loan"+type, HttpMethod.GET, entity, Response.class).getBody();

	}

	@SuppressWarnings("unchecked")
	@PostMapping("/loan/add-loan")
	public Response<LoanProgram> addLoanProgram(@RequestBody LoanProgram program) {
		LoanProgram loanProgram1 = loanProgramService.saveProgram(program);
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<LoanProgram> entity = new HttpEntity<LoanProgram>(program,headers);
	      
	      return template.exchange("http://localhost:8082/api/loan/add-loan", HttpMethod.POST, entity, Response.class).getBody();
	  
	}

	@SuppressWarnings("unchecked")
	@PutMapping("/loan")
	public Response<LoanProgram> updateLoanProgram(@RequestBody LoanProgram program) {
	//	program.setLoanId(0);
		LoanProgram loanProgram1 = loanProgramService.saveProgram(program);
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<LoanProgram> entity = new HttpEntity<LoanProgram>(program,headers);
	      
	      return template.exchange("http://localhost:8082/api/loan/", HttpMethod.PUT, entity, Response.class).getBody();

	}

	@SuppressWarnings("unchecked")
	@DeleteMapping("/loan/delete/{type}")
	public Response<LoanProgram> deleteProgram(@PathVariable String type) {
		LoanProgram program = loanProgramService.findByName(type);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange("http://localhost:8082/api/loan/delete"+type, HttpMethod.GET, entity, Response.class).getBody();

		
	}

	// pagination
	@SuppressWarnings("unchecked")
	@GetMapping("/loan/{pageNo}/{itemsPerPage}")
	public Page<LoanProgram> getPrograms(@PathVariable int pageNo, @PathVariable int itemsPerPage) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange("http://localhost:8082/api/loan/" + pageNo +itemsPerPage, HttpMethod.GET, entity, Page.class).getBody();

	}

	// sorting
	@SuppressWarnings("unchecked")
	@GetMapping("/loan/{pageNo}/{itemsPerPage}/{fieldName}")
	public Page<LoanProgram> getSortPrograms(@PathVariable int pageNo, @PathVariable int itemsPerPage,
			@PathVariable String fieldName) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange("http://localhost:8082/api/loan/" + pageNo +itemsPerPage +fieldName, HttpMethod.GET, entity, Page.class).getBody();


	}

}
