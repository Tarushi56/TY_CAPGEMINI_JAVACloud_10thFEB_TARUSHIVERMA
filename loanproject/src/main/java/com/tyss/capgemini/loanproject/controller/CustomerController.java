package com.tyss.capgemini.loanproject.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static  com.tyss.capgemini.loanproject.util.FactoryClass.*;
import com.tyss.capgemini.loanproject.dao.*;
import com.tyss.capgemini.loanproject.services.*;
import static com.tyss.capgemini.loanproject.repository.Repository.*;

public class CustomerController {
	static Scanner scanner = new Scanner(System.in);
	static Logger logger = LogManager.getLogger(CustomerController.class);

	public static void controlCustomer(String username) {
		// Repository.UserTable();
		boolean exit = false;
		while (exit != true) {
			logger.info("Customer Operations:-");
			logger.info("1> Loan Programs:");
			logger.info("2> Apply for loan: ");
			logger.info("3> Pay Loan: ");
			logger.info("4> change password: ");
			logger.info("5> Check Balance: ");
			logger.info("6> Logout");
			logger.info("Enter your choice: ");
			int choice = LoginController.scanner.nextInt();
			LoginController.scanner.nextLine();
			switch (choice) {
			case 1:
				for (int i = 0; i < LOANTYPE_LIST.size(); i++)
					logger.info(getCustomerServices().viewLoanPrograms());
				break;

			case 2:
				try {
					logger.info("enter the applicationId: ");
					String applicationId = LoginController.scanner.nextLine();
					logger.info("enter the loan account number: ");
					String accountNo = LoginController.scanner.nextLine();
					logger.info("enter the Applicant First Name: ");
					String applicantFirstName = LoginController.scanner.nextLine();
					logger.info("enter the Middle Name: ");
					String applicantMiddleName = LoginController.scanner.nextLine();
					logger.info("enter the Last Name");
					String applicantLastName = LoginController.scanner.nextLine();
					logger.info("enter the Co-Applicant First Name: ");
					String coapplicantFirstName = LoginController.scanner.nextLine();
					logger.info("enter the Middle Name");
					String coapplicantMiddleName = LoginController.scanner.nextLine();
					logger.info("enter the Last Name");
					String coapplicantLastName = LoginController.scanner.nextLine();
					logger.info("enter the Date of Birth: ");
					String dateOfBirth = LoginController.scanner.nextLine();
					logger.info("enter the Loan Type");
					String loanChoice = LoginController.scanner.nextLine();
					logger.info("enter the Branch Code");
					String branchCode = LoginController.scanner.nextLine();
					logger.info("enter the Branch Name");
					String branchName = LoginController.scanner.nextLine();
					logger.info("enter the open date");
					String openDate = LoginController.scanner.nextLine();
					logger.info("enter the Request Date");
					String requestDate = LoginController.scanner.nextLine();
					logger.info("SUBMIT    (or)    CANCEL");
					String sub = LoginController.scanner.nextLine();
					getCustomerServices().loanApplicationForm(applicationId, accountNo, applicantFirstName,
							applicantMiddleName, applicantLastName, dateOfBirth, coapplicantFirstName,
							coapplicantMiddleName, coapplicantLastName, loanChoice, branchCode, branchName, openDate,
							requestDate, sub);
				} catch (Exception e) {
					logger.info(e);
				}
				break;

			case 3:
				try {
					logger.info("Your current balance is: ");
					logger.info(getCustomerServices().checkBalance(username));
					logger.info("Loan to be paid: ");
					logger.info(getCustomerServices().checkLoan(username));
					logger.info("Enter the amount to pay: ");
					Double loanPay = LoginController.scanner.nextDouble();
					LoginController.scanner.nextLine();
					getCustomerServices().payLoan(username, loanPay);
					logger.info("New Balance is: ");
					logger.info(getCustomerServices().checkBalance(username));
				} catch (Exception e) {
					logger.error(e);
				}
				break;

			case 4:
				try {
					logger.info("enter the new password: ");
					String newPass = LoginController.scanner.nextLine();
					getCustomerServices().changePassword(username, newPass);
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
				break;

			case 5:
				logger.info("your current balance: INR " + getCustomerServices().checkBalance(username));
				break;

			case 6:
				exit = true;
				break;

			default:
				logger.info("Invalid Option");
				break;
			}
		}
	}

}
