package com.tyss.capgemini.loanproject.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static com.tyss.capgemini.loanproject.repository.Repository.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tyss.capgemini.loanproject.controller.*;

public class LoginDAOImpl implements LoginDAO {
	Logger logger = LogManager.getLogger(LoginDAOImpl.class);

	@Override
	public boolean custLogin(String custUsername, String custPass) {

		int count = 0;
		if (CUSTOMER_LIST.isEmpty() != true) {
			for (int i = 0; i < CUSTOMER_LIST.size(); i++) {
				if (CUSTOMER_LIST.get(i).get("username").equals(custUsername)
						&& CUSTOMER_LIST.get(i).get("password").equals(custPass)) {
					count++;
					if (CUSTOMER_LIST.get(i).get("role").equals("customer")) {
						logger.info("--------WELCOME " + custUsername + "---------");
						CustomerController.controlCustomer(custUsername);
					}
					return true;
				}
			}
		} else
			System.out.println("XXXX No Users available XXXX");
		return false;
	}

	@Override
	public boolean empLogin(String empUsername, String empPass) {
		if (EMPLOYEE_LIST.isEmpty() != true) {
			for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
				if (EMPLOYEE_LIST.get(i).get("username").equals(empUsername)
						&& EMPLOYEE_LIST.get(i).get("password").equals(empPass)) {
					if (EMPLOYEE_LIST.get(i).get("role").equals("admin")) {
						logger.info("--------WELCOME " + empUsername + "--------");
						AdminController.controlAdmin();
					} else {
						logger.info("--------WELCOME " + empUsername + "--------");
						LADController.ladController();
						
					}
					return true;
					
				}
			}
		} else
			System.out.println("XXXX No users available XXXX");
		return false;

	}

	@Override
	public boolean register(String occupation, String dob, String gender, String username, String userid, String email,
			String password, String firstname, String lastname, long phone, double accountBal) {
		HashMap<String, Object> regHashMap = new LinkedHashMap<String, Object>();
		regHashMap.put("userid", userid);
		regHashMap.put("password", password);
		regHashMap.put("username", username);
		regHashMap.put("email", email);
		regHashMap.put("firstname", firstname);
		regHashMap.put("lastname", lastname);
		regHashMap.put("phone", phone);
		regHashMap.put("AccountBal", accountBal);
		regHashMap.put("role", "customer");
		regHashMap.put("loanAmount", 0);
		CUSTOMER_LIST.add(regHashMap);
		MAIN_LIST.add(regHashMap);
		return true;
	} 

}
