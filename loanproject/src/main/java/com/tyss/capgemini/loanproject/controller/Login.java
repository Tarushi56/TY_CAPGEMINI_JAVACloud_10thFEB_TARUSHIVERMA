package com.tyss.capgemini.loanproject.controller;

import java.util.Scanner;

import javax.naming.InvalidNameException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tyss.capgemini.loanproject.exception.DateFormatMismatchException;
import com.tyss.capgemini.loanproject.exception.InvalidDataException;
import com.tyss.capgemini.loanproject.exception.InvalidEmailFormatException;
import com.tyss.capgemini.loanproject.exception.InvalidPhoneNumberException;
import com.tyss.capgemini.loanproject.exception.PasswordFormatMismatchException;
import com.tyss.capgemini.loanproject.exception.UsernameAlreadyExistsException;
import com.tyss.capgemini.loanproject.repository.Repository;
import com.tyss.capgemini.loanproject.util.FactoryClass;
import com.tyss.capgemini.loanproject.validation.Validation;

public class Login {
	static Scanner scanner = new Scanner(System.in);

	public static void loginController() {
		Repository.UserTable();
		Validation validationClass = new Validation();
		boolean exit = false;
		boolean count = false;
		Logger logger = LogManager.getLogger(Login.class);
		while (exit != true) {
			logger.info("********************* WELCOME ********************");
			logger.info("1> Login as Customer?");
			logger.info("2> Login as Employee?");
			logger.info("3> New user? Register");
			logger.info("4> Exit");
			logger.info("**************************************************");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				String custUsername = null;
				String custPass = null;
				logger.info("---------CUSTOMER LOGIN---------");
				while(count == false) {
				logger.info("Enter the Username:-");
				custUsername = scanner.nextLine();
				try {
					if (validationClass.usernameValid(custUsername) == false) {
						throw new UsernameAlreadyExistsException("enter valid username (letters and numbers, max-15)");
					} else {
						count = true;
					}
				} catch (Exception e) {
					logger.info(e.getMessage());
				}}
				count = false;
				while(count == false) {
					logger.info("Enter the Password:-");
					custPass = scanner.nextLine();
					try {
						if (validationClass.passValid(custPass) ) {
							throw new PasswordFormatMismatchException("enter valid Password (Should contain 1Uppercase, 1Lowercase, 1Special Char, 1Number, Range-(6-20))");
						} else {
							count = true;
						}
					} catch (Exception e) {
						logger.info(e.getMessage());
					}}
				count = false;
//				logger.info("Enter the Password:-");
//				String custPass = scanner.nextLine();
				try {
					FactoryClass.getLoginServices().custLogin(custUsername, custPass);
				} catch (Exception e) {
					logger.info(e.getMessage());
				}
				break;
				
			case "2":
				String empUsername = null;
				String empPass = null;
			//	boolean count1 = false;
				logger.info("---------EMPLOYEE LOGIN---------");
				while(count == false) {
					logger.info("Enter the Username:-");
					empUsername = scanner.nextLine();
					try {
						if (validationClass.usernameValid(empUsername) == false) {
							throw new InvalidNameException("enter valid username (letters and numbers, max-15)");
						} else {
							count = true;
						}
					} catch (Exception e) {
						logger.info(e.getMessage());
					}}
					count = false;
					while(count == false) {
						logger.info("Enter the Password:-");
						empPass = scanner.nextLine();
						try {
							if (validationClass.passValid(empPass) == false) {
								throw new PasswordFormatMismatchException("enter valid Password (Should contain 1Uppercase, 1Lowercase, 1Special Char, 1Number, Range-(6-20))");
							} else {
								count = true;
							}
						} catch (Exception e) {
							logger.info(e.getMessage());
						}}
					count = false;
					try {
						FactoryClass.getLoginServices().empLogin(empUsername, empPass);
					} catch (Exception e) {
						logger.info(e.getMessage());
					}
					break;
			case "3":
				boolean flag = false;
				String firstname = null;
				String lastname = null;
				String email = null;
				String password = null;
				String username = null;
				String gender = null;
				String dob = null;
				String phoneString = null;
				Long phone = null;
				String occupation = null;
				double balance = 0.0;
				String userid=null;
				logger.info("-----------REGISTER----------");
				while (!flag) {
					logger.info("Enter the First Name: ");
					firstname = scanner.nextLine();
					try {
						if (validationClass.nameValid(firstname) == false) {
							throw new InvalidDataException("first name can have letters only!!");
						} else {
							flag = true;
						}
					} catch (Exception e) {
						logger.info(e.getMessage());
					}
				}
				flag = false;
				while (!flag) {
					logger.info("Enter the Last Name: ");
					lastname = scanner.nextLine();
					try {
						if (validationClass.nameValid(lastname) == false) {
							throw new InvalidDataException("last name can have letters only!!");
						} else {
							flag = true;
						}
					} catch (Exception e) {
						logger.info(e.getMessage());
					}
				}
				flag = false;
				while (!flag) {
					logger.info("Enter username: ");
					username = scanner.nextLine();
					try {
						if (validationClass.usernameValid(username) == false) {
							throw new InvalidNameException("Follow the pattern (can have only numbers or letters");
						} else {
							try {
								if (FactoryClass.getLoginServices().usernameExists(username) == false) {
									throw new InvalidNameException("this username already exists!!!");
								} else {
									flag = true;
								}
							} catch (Exception e) {
								logger.info(e.getMessage());
							}
						}
					} catch (Exception e) {
						logger.info(e.getMessage());
					}
				}
				flag = false;
				while (!flag) {
					logger.info("Enter email: ");
					email = scanner.nextLine();
					try {
						if (validationClass.mailValid(email) == false) {
							throw new InvalidEmailFormatException("Please enter a valid email");
						} else {
							try {
								if (FactoryClass.getLoginServices().emailExists(email) == false) {
									throw new InvalidEmailFormatException("this email already exists!!!");
								} else {
									flag = true;
								}
							} catch (Exception e) {
								logger.info(e.getMessage());
							}
						}
					} catch (Exception e) {
						logger.info(e.getMessage());
					}
				}
				flag = false;
				while (!flag) {
					logger.info("Enter password: ");
					password = scanner.nextLine();
					try {
						if (validationClass.passValid(password) == false) {
							throw new PasswordFormatMismatchException("Password pattern should match");
						} else {
							flag = true;
						}
					} catch (Exception e) {
						logger.info(e.getMessage());
					}
				}
				flag = false;
				while (!flag) {
					logger.info("Enter gender: ");
					logger.info("1> Male");
					logger.info("2> Female");
					logger.info("choose :-");
					String chooseString = scanner.nextLine();
					switch (chooseString) {
					case "1":
						gender = "Male";
						flag = true;
						break;
					case "2":
						gender = "Female";
						flag = true;
						break;
					default:
						logger.info("invalid choice, please choose again!!!");
						break;
					}
				}
				flag = false;
				while (!flag) {
					logger.info("Enter date of birth: ");
					dob = scanner.nextLine();
					try {
						if (validationClass.dateValid(dob) == false) {
							throw new DateFormatMismatchException("Date pattern should match (DD/MM/YYYY)");
						} else {
							flag = true;
						}
					} catch (Exception e) {
						logger.info(e.getMessage());
					}
				}
				flag = false;
				while (!flag) {
					logger.info("Enter Phone no: ");
					phoneString = scanner.nextLine();
					try {
						if (validationClass.phoneValid(phoneString) == false) {
							throw new InvalidPhoneNumberException("Invalid phone number(10 digits)!!!");
						} else {
							phone = Long.parseLong(phoneString);
							flag = true;
						}
					}catch (Exception e) {
						logger.info(e.getMessage());
					}
				}
				flag = false;
				while (!flag) {
					logger.info("Enter occupation: ");
					occupation = scanner.nextLine();
					try {
						if (validationClass.fullNameValid(occupation) == false) {
							throw new InvalidDataException("occupation can have letters only!!");
						} else {
							flag = true;
						}
					} catch (Exception e) {
						logger.info(e.getMessage());
					}
				}
				flag = false;
				
				while(!flag) {
					logger.info("Enter balance:");
					String stringBalance = scanner.nextLine();
					if(validationClass.doubleValid(stringBalance) == false){
						logger.info("not a valid balance");
					}
					else {
						balance = Double.parseDouble(stringBalance);
						flag=true;
					}
				}
				logger.info("Enter userid:");
				userid = scanner.nextLine();
				
				if(FactoryClass.getLoginServices().register(occupation, dob, gender, username, userid, email, password, firstname,
							lastname, phone, balance)) {
					logger.info("user successfully added");
				}
				else
					logger.info("something went wrong!!!");
				break;

			case "4":
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
