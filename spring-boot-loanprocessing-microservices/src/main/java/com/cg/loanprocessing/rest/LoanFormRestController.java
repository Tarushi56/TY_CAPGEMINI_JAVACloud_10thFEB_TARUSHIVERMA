package com.cg.loanprocessing.rest;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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

//import com.cg.loanprocessing.entity.JwtResponse;
import com.cg.loanprocessing.entity.LoanForm;
import com.cg.loanprocessing.exception.ApplicationNotFoundException;
import com.cg.loanprocessing.response.JwtResponse;
import com.cg.loanprocessing.response.Response;
import com.cg.loanprocessing.service.JwtUtil;
import com.cg.loanprocessing.service.LoanFormService;
import com.cg.loanprocessing.service.LoanFormServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LoanFormRestController {
	@Autowired
	private RestTemplate template;

	@Autowired
	private LoanFormService service;

	public LoanFormRestController(LoanFormService service) {
		this.service = service;
	}

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoanForm form) throws Exception {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword()));
		} catch (DisabledException de) {
			// we should use loggers here
			System.out.println("User is Disabled");
			throw new Exception("USER_DISABLED", de);

		} catch (BadCredentialsException bce) {
			// we should use loggers here
			throw new Exception("INVALID_CREDENTIALS", bce);

		} // End of try catch

		final UserDetails userDetails = userDetailsService.loadUserByUsername(form.getEmail());
		final String role, email, fullName;
		final Integer loanId;
		email = form.getEmail(); 
		LoanForm form1 = service.searchByEmail(email);
		role = form1.getRole();
		loanId=form1.getLoanId();
		fullName = form1.getFullName();
		final String jwt = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(jwt, email, loanId, "", role,fullName));// doubt
	}// End of login

	// api
	@SuppressWarnings("unchecked")
	@GetMapping("/form")
	public List<LoanForm> getAllForms() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange("http://localhost:8081/api/form", HttpMethod.GET, entity, List.class).getBody();

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/form/{formId}")
	public Response<LoanForm> getFormsById(@PathVariable int formId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		//int loanidint = Integer.parseInt(formId);
		return template.exchange("http://localhost:8081/api/form/" + formId, HttpMethod.GET, entity, Response.class).getBody();

	}

	@SuppressWarnings("unchecked")
	@PostMapping("/form/add")
	public Response<LoanForm> addForms(@Valid @RequestBody LoanForm form) {
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<LoanForm> entity = new HttpEntity<LoanForm>(form,headers);
	      
	      return template.exchange(
	         "http://localhost:8081/form/add", HttpMethod.POST, entity, Response.class).getBody();
	  
	}

	@SuppressWarnings("unchecked")
	@PutMapping("/form")
	public Response <LoanForm> updateForm(@RequestBody LoanForm form) {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<LoanForm> entity = new HttpEntity<LoanForm>(form,headers);
	      
	      return template.exchange("http://localhost:8081/form/", HttpMethod.PUT, entity, Response.class).getBody();
	  
	}

	@SuppressWarnings("unchecked")
	@DeleteMapping("form/{formId}")
	public Response<LoanForm> deleteForm(@PathVariable int formId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange(" http://localhost:8081/form/" + formId, HttpMethod.DELETE, entity, Response.class).getBody();


	}

	// pagination
	@SuppressWarnings("unchecked")
	@GetMapping("/form/{pageNo}/{itemsPerPage}")
	public Page<LoanForm> getForms(@PathVariable int pageNo, @PathVariable int itemsPerPage) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange(" http://localhost:8081/form/" + pageNo +itemsPerPage, HttpMethod.GET, entity, Page.class).getBody();

	}

	// sorting
	@SuppressWarnings("unchecked")
	@GetMapping("/form/{pageNo}/{itemsPerPage}/{fieldName}")
	public Page<LoanForm> getSortForms(@PathVariable int pageNo, @PathVariable int itemsPerPage,
			@PathVariable String fieldName) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange(" http://localhost:8081/form/" + pageNo +itemsPerPage +fieldName, HttpMethod.GET, entity, Page.class).getBody();

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/getCustomer/{pageNo}/{itemsPerPage}")
	public Page<LoanForm> getAllCustomer(@PathVariable int pageNo, @PathVariable int itemsPerPage) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange(" http://localhost:8081/form/" + pageNo +itemsPerPage, HttpMethod.GET, entity, Page.class).getBody();

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/getSortCustomer/{pageNo}/{itemsPerPage}/{fieldName}")
	public Page<LoanForm> getAllSortCustomer(@PathVariable int pageNo, @PathVariable int itemsPerPage,
			@PathVariable String fieldName) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange(" http://localhost:8081/form/" + pageNo +itemsPerPage +fieldName, HttpMethod.GET, entity, Page.class).getBody();

	}
}
