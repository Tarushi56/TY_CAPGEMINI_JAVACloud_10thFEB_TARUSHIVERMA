package com.cg.loanprocessing.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
		final String role,email,fullName;
		email=form.getEmail();
		
		LoanForm form1 =  service.searchByEmail(email);
		role=form1.getRole();
		fullName=form1.getFullName();
		final String jwt = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(jwt, email, "", role, fullName));// doubt
	}// End of login
	
	// api 
	@GetMapping("/form")
	public List<LoanForm> getAllForms(){
		return service.findAll();
	}
	
	@GetMapping("/form/{formId}")
	public Response<LoanForm> getFormsById(@PathVariable int formId) {
		LoanForm form=service.findById(formId);
		if (form!=null) {
			return new Response<>(false,"record found",form);
		} else {
			throw new ApplicationNotFoundException("form not found");
		}
		
		
	}
	@PostMapping("/form/add")
	 public Response<LoanForm> addForms(@Valid @RequestBody LoanForm form) {
		// form.setLoanId(0);
		 form.setApplicationStatus("Requested");
		 form.setRole("ROLE_CUSTOMER");
		 LoanForm loanform =service.save(form);
		 if(loanform!=null) {
			 return new Response<LoanForm>(false,"Form added successfully",loanform); 
		 }else {
			 return new Response<LoanForm>(true,"form not added",null);
		 }
	 }
	@PutMapping("/form")
	public LoanForm updateForm( @RequestBody LoanForm form) {
		LoanForm form1=service.save(form);
		return form1;
	}
	@DeleteMapping("form/{formId}")
	public void deleteForm(@PathVariable int formId) {
		LoanForm form=service.findById(formId);
		if(form!=null) {
			service.delete(formId);
			System.out.println("sucess");
		}
	}
	
	//pagination
	@GetMapping("/form/{pageNo}/{itemsPerPage}")
	public Page<LoanForm> getForms(@PathVariable int pageNo, @PathVariable int itemsPerPage ){
		return service.getForms(pageNo, itemsPerPage);
	}
	//sorting
	@GetMapping("/form/{pageNo}/{itemsPerPage}/{fieldName}")
	public Page<LoanForm> getSortForms(@PathVariable int pageNo ,@PathVariable int itemsPerPage,@PathVariable String fieldName){
		return service.getSortForms(pageNo, itemsPerPage, fieldName);
		
	}

	@GetMapping("/getCustomer/{pageNo}/{itemsPerPage}")
	public Page<LoanForm> getAllCustomer(@PathVariable int pageNo ,@PathVariable int itemsPerPage){ 
		return service.findAllCustomer(pageNo, itemsPerPage);
	}
	
	@GetMapping("/getSortCustomer/{pageNo}/{itemsPerPage}/{fieldName}")
	public Page<LoanForm> getAllSortCustomer(@PathVariable int pageNo,@PathVariable int itemsPerPage,@PathVariable String fieldName) {
		return service.findAllSortedCustomer(pageNo, itemsPerPage, fieldName);
	}
}
