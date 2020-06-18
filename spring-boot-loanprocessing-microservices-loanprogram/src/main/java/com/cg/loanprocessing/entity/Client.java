package com.cg.loanprocessing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="Client")
public class Client {
	
	@NotNull
	@NotEmpty(message="Please enter your name")
	@Pattern(regexp = "[a-z A-Z]*")
	@Size(min=3,message="Name should contain atleast 3 characters")
	@Column(name="full_name")
	private String fullName;
	
	@Id
	@Column
	@Email
	@NotNull
	@NotEmpty(message="Please enter your email")
	@Size(min=10,message="Email must have 10 characters")
	private String email;
	
	@NotNull
	@NotEmpty(message="Please enter password")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message="should contain atleast one number, one uppercase, one lowercase and a special character")
	@Column
	private String password;
	
	@Column
	@NotNull
	private String role;
	
	@Column
	@NotNull
	private String phone;

}
