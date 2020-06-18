package com.cg.loanprocessing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="applicant_info")
public class Applicant {
	@Id
	@Column(name = "application_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appId;
	
	@NotNull
	@Column(name = "loan_type", nullable = false)
	private String loanType;
	
	@NotNull
	@Column(name = "loan_amount", nullable = false)
	private String loanAmount;
	
	@NotNull
	@Column(name = "application_status", nullable = false)
	private String applicationStatus;
}
