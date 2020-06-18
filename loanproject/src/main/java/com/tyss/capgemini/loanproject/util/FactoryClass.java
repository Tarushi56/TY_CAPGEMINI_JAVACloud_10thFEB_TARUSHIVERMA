package com.tyss.capgemini.loanproject.util;

import com.tyss.capgemini.loanproject.dao.*;
import com.tyss.capgemini.loanproject.services.*;
public class FactoryClass {
    
	public static CustomerServices getCustomerServices() {
		return new CustomerServicesImpl();
	}
	
	public static CustomerDAO getCustomerDao() {
		return new CustomerDAOImpl();
	}
	
	public static AdminServices getAdminServices() {
		return new AdminServicesImpl();
	}
	
	public static AdminDAO getAdminDao() {
		return new AdminDAOImpl();
	}
	
	public static LoginServices getLoginServices() {
		return new LoginServicesImpl();
	}
	
	public static LoginDAO getLoginDao() {
		return new LoginDAOImpl();
	}
	
	public static LadServices getLadServices() {
		return new LadServicesImpl();
	}
	
	public static LadDAO getLadDao() {
		return new LadDAOImpl();
	}	
}
