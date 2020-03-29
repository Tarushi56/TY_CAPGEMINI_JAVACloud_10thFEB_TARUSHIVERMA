package com.tyss.capgemini.loanproject.services;

import java.util.HashMap;
import java.util.List;

public interface LadServices {
	public List<HashMap<String, Object>> viewLoanPrograms();
	public boolean ladReviewForms(String apid, String status);
	public List<HashMap<String, Object>> ladViewForms(String planString);
	public List<HashMap<String, Object>> requestedForms();
}
