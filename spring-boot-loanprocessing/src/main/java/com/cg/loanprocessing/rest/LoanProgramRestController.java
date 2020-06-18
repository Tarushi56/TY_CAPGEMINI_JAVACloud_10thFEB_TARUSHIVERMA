package com.cg.loanprocessing.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	private LoanProgramService loanProgramService;

	@Autowired
	public LoanProgramRestController(LoanProgramService loanProgramService) {
		this.loanProgramService = loanProgramService;
	}

	@GetMapping("/loan")
	public List<LoanProgram> findAllProgram() {
		return loanProgramService.findAllProgram();
	}

	@GetMapping("/loan/{type}")
	public Response<LoanProgram> getLoan(@PathVariable String type) {
		LoanProgram program = loanProgramService.findByName(type);
		if (program != null) {
			return new Response<LoanProgram>(false, "record found", program);
		} else {
			throw new LoanProgramNotFoundException("record not found");
		}
	}

	@PostMapping("/loan/add-loan")
	public Response<LoanProgram> addLoanProgram(@RequestBody LoanProgram program) {
		LoanProgram loanProgram1 = loanProgramService.saveProgram(program);
		if (loanProgram1 != null) {
			return new Response<LoanProgram>(false, "program saved successfully", program);
		} else {
			return new Response<LoanProgram>(true, "program not saved ", null);
		}
	}

	@PutMapping("/loan")
	public Response<LoanProgram> updateLoanProgram(@RequestBody LoanProgram program) {
		// program.setLoanId(0);

		LoanProgram loanProgram1 = loanProgramService.updateProgram(program);
		if (loanProgram1 != null) {
			return new Response<LoanProgram>(false, "program updated successfully", loanProgram1);
		} else {
			return new Response<LoanProgram>(true, "program not updated ", null);
		}
	}

	@DeleteMapping("/loan/delete/{type}")
	public Response<LoanProgram> deleteProgram(@PathVariable String type) {
		LoanProgram program = loanProgramService.findByName(type);
		if (program != null) {
			loanProgramService.deleteProgram(type);
			return new Response<LoanProgram>(false, "program deleted", program);
		} else {
			throw new LoanProgramNotFoundException(" program not found");
		}

	}

	// pagination
	@GetMapping("/loan/{pageNo}/{itemsPerPage}")
	public Page<LoanProgram> getPrograms(@PathVariable int pageNo, @PathVariable int itemsPerPage) {
		return loanProgramService.getPrograms(pageNo, itemsPerPage);
	}

	// sorting
	@GetMapping("/loan/{pageNo}/{itemsPerPage}/{fieldName}")
	public Page<LoanProgram> getSortPrograms(@PathVariable int pageNo, @PathVariable int itemsPerPage,
			@PathVariable String fieldName) {
		return loanProgramService.getSortPrograms(pageNo, itemsPerPage, fieldName);

	}

}
