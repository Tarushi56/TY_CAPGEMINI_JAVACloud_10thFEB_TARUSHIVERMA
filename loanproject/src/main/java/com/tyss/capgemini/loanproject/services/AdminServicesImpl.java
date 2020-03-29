package com.tyss.capgemini.loanproject.services;

import java.util.HashMap;
import java.util.List;
import static com.tyss.capgemini.loanproject.repository.Repository.*;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;
import  com.tyss.capgemini.loanproject.exception.*;
public class AdminServicesImpl implements AdminServices {
	@Override
	public boolean addClients(String appidString) {
		if( getAdminDAO().addClients(appidString)) {
			return true;
		}
		throw new InvalidAppliactionIdException("Invalid applicationId!!!");
			
	}

	@Override
	public List<HashMap<String,Object>> viewClients() {
		return getAdminDAO().viewClients();
	}
	
	@Override
	public boolean loanUpdate(String typechoice, int choice2, String choice3) {
		for (int i = 0; i < LOANTYPE_LIST.size(); i++) {
			if (typechoice.equalsIgnoreCase((String)LOANTYPE_LIST.get(i).get("Type"))) {
				if(getAdminDAO().loanUpdate(typechoice, choice2, choice3))
					return true;
			}
			else
				throw new InvalidLoanTypeException("Loan type doesnt exist");
		}
		return false;
			
		
	}

	@Override
	public boolean insertLoan(String type, String time, String rates) {
		return getAdminDAO().insertLoan(type, time, rates);
	}

	@Override
	public boolean deleteLoan(String loantype) {
		for (int i = 0; i < LOANTYPE_LIST.size(); i++) {
			if (getAdminDAO().deleteLoan(loantype)) {
				return true;
			}
			else {
				throw new InvalidLoanTypeException("Loan type doesnt exist");
			}
		}
		return false;
			
	}
	
	@Override
	public List<HashMap<String, Object>> viewLoanPrograms() {
		return getAdminDAO().viewLoanPrograms();
	}
	
	@Override
	public List<HashMap<String, Object>> approvedForms() {
		return getAdminDAO().approvedForms();
	}

	@Override
	public List<HashMap<String,Object>> rejectedForms() {
		return getAdminDAO().rejectedForms();
	}

	@Override
	public List<HashMap<String,Object>> requestedForms() {
		return getAdminDAO().requestedForms();
	}
}
