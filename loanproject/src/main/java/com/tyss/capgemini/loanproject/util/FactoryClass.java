package com.tyss.capgemini.loanproject.util;

import com.tyss.capgemini.loanproject.dao.*;
import com.tyss.capgemini.loanproject.services.*;
import com.tyss.capgemini.loanproject.repository.*;
import com.tyss.capgemini.loanproject.validation.*;
public class FactoryClass {
    
	public static CustomerDAO getCustomerDAO() {
		return new CustomerDAOImpl();
	}	
	
	public static AdminDAO getAdminDAO() {
		return new AdminDAOImpl();
	}
	
	public static LadDAO getLadDAO() {
		return new LadDAOImpl();
	}
	
	public static LoginDAO getLoginDAO() {
		return new LoginDAOImpl();
	}
	
	public static  LoginServices getLoninServices() {
		return new LoginServicesImpl();
	}
	
	public static CustomerServices getCustomerServices() {
		return new CustomerServicesImpl();
	}
	
	public static AdminServices getAdminServices() {
		return new AdminServicesImpl();
	}
	
	public static LadServices getLadServices() {
		return new LadServicesImpl();
	}
	
	public static LoginServices getLoginServices() {
		return new LoginServicesImpl();
	}
	
	public static Validation getValidation() {
		return new Validation();
	}
	
}
