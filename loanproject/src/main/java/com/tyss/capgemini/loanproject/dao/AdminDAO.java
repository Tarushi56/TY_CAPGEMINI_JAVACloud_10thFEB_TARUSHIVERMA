package com.tyss.capgemini.loanproject.dao;

import java.util.HashMap;
import java.util.List;

public interface AdminDAO {
	public boolean loanUpdate(String typechoice, int choice2, String choice3);

	public boolean insertLoan(String type, String time, String rates);

	public boolean deleteLoan(String loantype);

	public List<HashMap<String, Object>> viewLoanPrograms();

	public boolean addClients(String appidString);

	public List<HashMap<String, Object>> viewClients();

	public List<HashMap<String, Object>> approvedForms();

	public List<HashMap<String, Object>> rejectedForms();

	public List<HashMap<String, Object>> requestedForms();
}
