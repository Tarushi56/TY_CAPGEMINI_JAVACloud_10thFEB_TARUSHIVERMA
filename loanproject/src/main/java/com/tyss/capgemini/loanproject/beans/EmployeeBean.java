package com.tyss.capgemini.loanproject.beans;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class EmployeeBean implements Serializable {

	private String username;
	private String userid;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private long phone;
	private String role;

	public EmployeeBean(String username, String userid, String email, String password, String firstname,
			String lastname, long phone, String role) {
		super();
		this.username = username;
		this.userid = userid;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public String getUserid() {
		return userid;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public long getPhone() {
		return phone;
	}

	public String getRole() {
		return role;
	}

}
