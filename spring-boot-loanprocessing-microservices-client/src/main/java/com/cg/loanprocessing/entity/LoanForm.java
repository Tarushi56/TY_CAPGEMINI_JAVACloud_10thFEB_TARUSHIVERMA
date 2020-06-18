package com.cg.loanprocessing.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "makeloan")
public class LoanForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private int loanId;
	
	@NotNull
	@NotEmpty(message="Please enter your name")
	@Pattern(regexp = "[a-z A-Z]*")
	@Size(min=3,message="Name should contain atleast 3 characters")
	@Column(name = "full_name")
	private String fullName;
	
	@Email
	@NotNull
	@NotEmpty(message="Please enter your email")
	@Size(min=10,message="Email must have 10 characters")
	@Column(name = "email")	
	private String email;
	
	//@NotNull
	//@NotEmpty(message="Please enter password")
//	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message="should contain atleast one number, one uppercase, one lowercase and a special character")
	@Column(name = "password")
	private String password;
	
//	@NotNull
//	@NotEmpty(message="Please enter your gender")
//	@Pattern(regexp = "Male|Female",message="select Male or Female")
	@Column(name = "gender")
	private String gender;
	
	@NotNull
	@NotEmpty(message="Please enter your age")
	@Pattern(regexp = "[0-9]{2}" ,message="Enter your age in digits")
	@Column(name = "age")
	private String age;
	
	
	@NotNull
	@NotEmpty(message="Please enter your Mobile Number")
	@Pattern(regexp = "^\\d{10}$" ,message="Mobile Number must be 10 digits")
	@Column(name = "mobile_number" )
	private String mobileNumber;
	
//	@NotNull
	//@NotEmpty(message="Please enter your PAN Number")
	//@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}" ,message="Enter your PAN Number ")
	@Column(name = "pan_number")
	private String panNumber;
	
	//@NotNull
	//@NotEmpty(message="Please enter your Loan Type")
	@Column(name = "loan_type")
	private String loanType;
	
	//@NotNull
//	@NotEmpty(message="Please enter your Address")
	@Column(name = "address")
	private String address;
	
	//@NotNull
	//@NotEmpty(message="Please enter your Loan Amount")
	@Pattern(regexp = "[0-9]{4,}" ,message="Enter your  Loan Amount ")
	@Column(name = "loan_amount")
	private String loanAmount;
	
	//@NotNull
	//@NotEmpty(message="Please enter your Salary")
	@Pattern(regexp = "[0-9]{4,}" ,message="Enter your Salary in digts")
	@Column(name = "salary")
	private String salary;
	
	@Column(name="application_status")
	private String applicationStatus;
	
	//@NotNull
//	@NotEmpty(message="Please enter your role")
//	@Pattern(regexp = "(ROLE_)+([A-Z]{5,15})" ,message="Enter your role as ROLE_XXXX")
	@Column
	private String role;

	
	@OneToMany(targetEntity = Applicant.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "loan_id", referencedColumnName = "loan_id")
//	@JsonManagedReference
	private List<Applicant> applicant;

}
