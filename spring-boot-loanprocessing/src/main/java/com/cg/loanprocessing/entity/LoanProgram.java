package com.cg.loanprocessing.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loan_program")
public class LoanProgram {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="program_id")
//	private int programId;
	
	@NotNull
	@NotEmpty(message="Please enter your Loan Type")
	@Column
	private String loanType;
	
	@NotNull
	@NotEmpty(message="Please enter your age")
//	@Pattern(regexp = "[0-9]{2}" ,message="Enter your age in digits")
	@Column
	private String age;
	
	@NotNull
	@NotEmpty(message="Please enter your period")
//	@Pattern(regexp = "[0-9]{2}" ,message="Enter period")
	@Column
	private String period;
	
	@NotNull
	@NotEmpty(message="Please enter your Interest Rate")
	@Column
	private String interestRate;
}
