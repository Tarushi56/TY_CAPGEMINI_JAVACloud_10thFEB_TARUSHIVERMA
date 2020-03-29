package com.tyss.capgemini.loanproject.controller;

import java.util.Scanner;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static com.tyss.capgemini.loanproject.repository.Repository.*;
import static  com.tyss.capgemini.loanproject.validation.Validation.*;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;
import com.tyss.capgemini.loanproject.exception.*;

public class LoginController {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		userTable();
		boolean exit = false;
		Logger logger = LogManager.getLogger(LoginController.class);
		while (exit != true) {
			logger.info(" WELCOME ");
			logger.info("1> Login as Customer?");
			logger.info("2> Login as Employee?");
			logger.info("3> New user? Register");
			logger.info("4> Exit");
			logger.info(" ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				logger.info("---------CUSTOMER LOGIN---------");
				logger.info("Enter the Username:-");
				String custUsername = scanner.nextLine();
				logger.info("Enter the Password:-");
				String custPass = scanner.nextLine();
				try {
					getLoginServices().custLogin(custUsername, custPass);
				} catch (Exception e) {
					logger.info(e);
				}
				break;

			case 2:
				logger.info("---------EMPLOYEE LOGIN---------");
				logger.info("Enter the Username:-");
				String empUsername = scanner.nextLine();
				logger.info("Enter the Password:-");
				String empPass = scanner.nextLine();
				try {
					getLoginServices().empLogin(empUsername, empPass);
				} catch (Exception e) {
					logger.info(e.getMessage());
				}
				break;

			case 3:
				logger.info("-----------REGISTER----------");
				logger.info("Enter the First Name: ");
				String firstname = scanner.nextLine();
				logger.info("Enter the Last name: ");
				String lastname = scanner.nextLine();
				logger.info("Enter the Email: ");
				String email = scanner.nextLine();
				logger.info("enter the Password: ");
				String password = scanner.nextLine();
				logger.info("Enter the Username: ");
				String username = scanner.nextLine();
				logger.info("Enter the Gender: ");
				String gender = scanner.nextLine();
				logger.info("Enter the Date of birth: ");
				String dob = scanner.nextLine();
				logger.info("Enter the Phone number: ");
				long phone = scanner.nextLong();
				scanner.nextLine();
				logger.info("Enter the Occupation: ");
				String occupation = scanner.nextLine();
				logger.info("Enter the account balance: ");
				double accountBal = scanner.nextDouble();
				scanner.nextLine();
				logger.info("Enter the userid: ");
				String userid = scanner.nextLine();
				getLoginServices().register(occupation, dob, gender, username, userid, email, password, firstname,
						lastname, phone, accountBal);
				break;

			case 4:
				exit = true;
				logger.info("Visit again...");
				scanner.close();
				break;
			default:
				logger.info("Wrong choice. Enter again");
				break;
			}
		}
	}
}
