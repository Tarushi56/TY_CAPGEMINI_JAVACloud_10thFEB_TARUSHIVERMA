package com.tyss.capgemini.loanproject.services;

import java.util.HashMap;
import java.util.List;
import static com.tyss.capgemini.loanproject.repository.Repository.*;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;
import  com.tyss.capgemini.loanproject.exception.*;
import com.tyss.capgemini.loanproject.repository.Repository;
import com.tyss.capgemini.loanproject.util.FactoryClass;
public class AdminServicesImpl implements AdminServices {
	
	@Override
	/**
	 * 
	 * @param email
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param phone
	 * @return
	 */
	public boolean addClients(String username,String email,String password,
			String firstname,String lastname,String phone) {
		if( FactoryClass.getAdminDao().addClients(username,email,password,
				firstname, lastname, phone)) {
			return true;
		}
		else
			return false;
	}

	@Override
	/**
	 * 
	 */
	public boolean viewClients() {
		if (FactoryClass.getAdminDao().viewClients()) {
			return true;
		} else return false;
	}
	
	@Override
	/**
	 * 
	 * @param typechoice
	 * @param choice2
	 * @param choice3
	 * @return
	 */
	public boolean loanUpdate(String typechoice, int choice2, String choice3) {
		int count = 0;
		for (int i = 0; i < Repository.loanTypeList.size(); i++) {
			if (typechoice.equalsIgnoreCase((String) Repository.loanTypeList.get(i).get("Type"))) {
				count ++;
				FactoryClass.getAdminDao().loanUpdate(typechoice, choice2, choice3);
				return true;
			}
		}
		if(count == 0) {
			throw new InvalidLoanTypeException("Loan type doesnt exist");
		}
		return false;
	}

	@Override
	/**
	 * 
	 * @param type
	 * @param time
	 * @param rates
	 * @return
	 */
	public boolean insertLoan(String type, String time, String rates) {
		if (FactoryClass.getAdminDao().insertLoan(type, time, rates)) {
			return true;
		} else return false;
	}

	@Override
	/**
	 * 
	 * @param loantype
	 * @return
	 */
	public boolean deleteLoan(String loantype) {
		int count = 0;
		for (int i = 0; i < Repository.loanTypeList.size(); i++) {
			if (loantype.equalsIgnoreCase((String) Repository.loanTypeList.get(i).get("Type"))) {
				count ++;
				FactoryClass.getAdminDao().deleteLoan(loantype);
				return true;
			}
		}
		if(count == 0) {
			throw new InvalidLoanTypeException("Loan type doesnt exist");
		}
		return false;
	}
	
	@Override
	/**
	 * 
	 * @return
	 */
	public boolean viewLoanPrograms() {
		if (FactoryClass.getAdminDao().viewLoanPrograms()) {
			return true;
		} else return false;
	}
	
	@Override
	/**
	 * 
	 * @return
	 */
	public boolean approvedForms() {
		if (FactoryClass.getAdminDao().approvedForms()) {
			return true;
		} else return false;
	}

	@Override
	/**
	 * 
	 * @return
	 */
	public boolean rejectedForms() {
		if (FactoryClass.getAdminDao().rejectedForms()) {
			return true;
		} else return false;
	}

	@Override
	/**
	 * 
	 * @return
	 */
	public boolean requestedForms() {
		if (FactoryClass.getAdminDao().requestedForms()) {
			return true;
		} else return false;
	}

	@Override
	/**
	 * 
	 * @return
	 */
	public boolean loanTypes() {
		return FactoryClass.getAdminDao().loanTypes();
	}

	@Override
	/**
	 * 
	 * @param k
	 * @return
	 */
	public String loanTypes(String k) {
		return FactoryClass.getAdminDao().loanTypes(k);
	}
	

	@Override
	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean emailExists(String email) {
		return FactoryClass.getLoginDao().emailExists(email);
	}

	@Override
	/**
	 * 
	 * @param username
	 * @return
	 */
	public boolean usernameExists(String username) {
		return FactoryClass.getLoginDao().usernameExists(username);
	}

	@Override
	/**
	 * 
	 * @param loanType
	 * @param newType
	 * @return
	 */
	public String updateType(String loanType, String newType) {
		return FactoryClass.getAdminDao().updateType(loanType, newType);
	}

	@Override
	/**
	 * 
	 * @param loanType
	 * @param newTime
	 * @return
	 */
	public boolean updateTimePeriod(String loanType, String newTime) {
		return FactoryClass.getAdminDao().updateTimePeriod(loanType, newTime);
	}

	@Override
	/**
	 * 
	 * @param loanType
	 * @param newRate
	 * @return
	 */
	public boolean updateRates(String loanType, String newRate) {
		return FactoryClass.getAdminDao().updateRates(loanType, newRate);
	}
}
