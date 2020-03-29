package com.tyss.capgemini.loanproject.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static com.tyss.capgemini.loanproject.util.FactoryClass.*;
import static com.tyss.capgemini.loanproject.repository.Repository.*;

public class LADController {
	Scanner scanner = new Scanner(System.in);
	Logger logger = LogManager.getLogger(LADController.class);

	public static void ladController() {
		Logger logger = LogManager.getLogger(LADController.class);
		boolean exit = false;
		while (exit != true) {
			logger.info("Loan Approval Department:");
			logger.info("1> View all Home loan programs: ");
			logger.info("2> View loan applications:");
			logger.info("3> Application review: ");
			logger.info("4> Logout");
			logger.info("Enter your choice: ");
			int ch = LoginController.scanner.nextInt();
			LoginController.scanner.nextLine();
			switch (ch) {
			case 1:
				getLadServices().viewLoanPrograms();
				break;

			case 2:
				logger.info("Enter the loan plan of applications:- ");
				String planString = LoginController.scanner.nextLine();
				getLadServices().ladViewForms(planString);
				break;

			case 3:
				logger.info("Requested forms:-");
				for(int i=0;i<getLadServices().requestedForms().size();i++) 
					logger.info(getLadServices().requestedForms());
				logger.info("enter the ApplicationId for review: ");
				String apid = LoginController.scanner.nextLine();
				logger.info("enter the status: ");
				String status = LoginController.scanner.nextLine();
				if(getLadServices().ladReviewForms(apid, status)) {
					logger.info("status successfully changed...");
				}
				else
					logger.info("something went wrong");
				break;
			case 4:
				exit = true;
				break;
			default:
				break;
			}
		}
	}

}
