package com.tyss.capgemini.loanproject.beans;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class LoanApplicationBean implements Serializable {

	private String applicationId;
	private String loanType;
	private String timePeriod;
	private String interestRates;
	private String accountNo;
	private String applicantFirstName;
	private String applicantMiddleName;
	private String applicantLastName;
	private String dateOfBirthString;
	private String coapplicantFirstName;
	private String coapplicantMiddleName;
	private String coapplicantLastName;
	private String dateOfBirth;
	private String loanChoice;
	private String branchCode;
	private String branchName;
	private String openDate;
	private String requestDate;
	private String formStatus;

	public LoanApplicationBean(String applicationId, String accountNo, String applicantFirstName,
			String applicantMiddleName, String applicantLastName, String dateOfBirth, String coapplicantFirstName,
			String coapplicantMiddleName, String coapplicantLastName, String loanChoice, String branchCode,
			String branchName, String openDate, String requestDate, String formStatus) {
		super();
		this.applicationId = applicationId;
		this.accountNo = accountNo;
		this.applicantFirstName = applicantFirstName;
		this.applicantMiddleName = applicantMiddleName;
		this.applicantLastName = applicantLastName;
		this.dateOfBirth = dateOfBirth;
		this.coapplicantFirstName = coapplicantFirstName;
		this.coapplicantMiddleName = coapplicantMiddleName;
		this.coapplicantLastName = coapplicantLastName;
		this.loanChoice = loanChoice;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.openDate = openDate;
		this.requestDate = requestDate;
		this.formStatus = formStatus;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public String getLoanType() {
		return loanType;
	}

	public String getTimePeriod() {
		return timePeriod;
	}

	public String getInterestRates() {
		return interestRates;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getApplicantFirstName() {
		return applicantFirstName;
	}

	public String getApplicantMiddleName() {
		return applicantMiddleName;
	}

	public String getApplicantLastName() {
		return applicantLastName;
	}

	public String getDateOfBirthString() {
		return dateOfBirthString;
	}

	public String getCoapplicantFirstName() {
		return coapplicantFirstName;
	}

	public String getCoapplicantMiddleName() {
		return coapplicantMiddleName;
	}

	public String getCoapplicantLastName() {
		return coapplicantLastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getLoanChoice() {
		return loanChoice;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public String getOpenDate() {
		return openDate;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public String getFormStatus() {
		return formStatus;

	}

}
