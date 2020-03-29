package com.tyss.capgemini.loanproject.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import static com.tyss.capgemini.loanproject.repository.Repository.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
	Logger logger = LogManager.getLogger(AdminDAOImpl.class);
	@Override
	public boolean loanUpdate(String typechoice, int choice2, String choice3) {
		for (int i = 0; i < LOANTYPE_LIST.size(); i++) {
			if (typechoice.equalsIgnoreCase((String)LOANTYPE_LIST.get(i).get("Type"))) {
				logger.info("found");
				switch (choice2) {
				case 1:
					LOANTYPE_LIST.get(i).put("Type", choice3);
					break;
				case 2:
					LOANTYPE_LIST.get(i).put("Time-Period", choice3);
					break;
				case 3:
					LOANTYPE_LIST.get(i).put("Interest-Rates", choice3);
					break;
				default:
					logger.info("Wrong choice, enter again: ");
					break;
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean insertLoan(String type, String time, String rates) {
		HashMap<String, Object> hashMap = new LinkedHashMap<String, Object>();
		hashMap.put("Type", type);
		hashMap.put("Time-Period", time);
		hashMap.put("Interest-Rates", rates);
		
		return true;
	}

	@Override
	public boolean deleteLoan(String loantype) {
		for (int i = 0; i < LOANTYPE_LIST.size(); i++) {
			if (loantype.equals(LOANTYPE_LIST.get(i).get("Type"))) {
				LOANTYPE_LIST.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<HashMap<String, Object>> viewLoanPrograms() {
		return LOANTYPE_LIST;
	}
	
	@Override
	public List<HashMap<String,Object>> approvedForms() {
		
		for (int i = 0; i < LOANFORM_LIST.size(); i++) {
			if (((String) LOANFORM_LIST.get(i).get("LoanStatus")).toLowerCase().equals("approved")) {
				APPROVEDFORM_LIST.add(LOANFORM_LIST.get(i));
			}
		}
		return APPROVEDFORM_LIST;
	}

	@Override
	public List<HashMap<String,Object>> rejectedForms() {
		for (int i = 0; i < LOANFORM_LIST.size(); i++) {
			if ("rejected".equalsIgnoreCase((String) LOANFORM_LIST.get(i).get("LoanStatus"))) {
				REJECTEDFORM_LIST.add(LOANFORM_LIST.get(i));
				
			}
		}
		return REJECTEDFORM_LIST;
			
		
	}

	@Override
	public List<HashMap<String,Object>> requestedForms() {
		
		for (int i = 0; i < LOANFORM_LIST.size(); i++) {
			if ("requested".equalsIgnoreCase((String) LOANFORM_LIST.get(i).get("LoanStatus"))) {
				REQUESTEDFORM_LIST.add(LOANFORM_LIST.get(i));
			}
		}
		return REQUESTEDFORM_LIST;
	}
	
	@Override
	public boolean addClients(String appidString) {
		int count = 0;
		for (int i = 0; i < LOANFORM_LIST.size(); i++) {
			if (appidString.equalsIgnoreCase((String)LOANFORM_LIST.get(i).get("ApplicationId"))) {
				CLIENT_LIST.add(LOANFORM_LIST.get(i));
				return true;
			}
		}
		return false;
	}

	@Override
	public List<HashMap<String,Object>> viewClients() {
		return CLIENT_LIST;
	}
}
