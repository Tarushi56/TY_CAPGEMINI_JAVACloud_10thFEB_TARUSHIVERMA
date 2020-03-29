package com.tyss.capgemini.loanproject.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import static com.tyss.capgemini.loanproject.repository.Repository.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LadDAOImpl implements LadDAO {
	Logger logger = LogManager.getLogger(LadDAOImpl.class);
	public static final List<HashMap<String, Object>> FORMS = new LinkedList<HashMap<String, Object>>();
	public static final List<HashMap<String, Object>> REQUESTED_FORMS = new LinkedList<HashMap<String, Object>>();

	@Override
	public List<HashMap<String, Object>> viewLoanPrograms() {
		return LOANTYPE_LIST;
	}

	@Override
	public boolean ladReviewForms(String apid, String status) {
		for (int j = 0; j < LOANFORM_LIST.size(); j++) {
			if (apid.equals((String) LOANFORM_LIST.get(j).get("ApplicationId"))) {
				if (status.equalsIgnoreCase("requested")) {
					LOANFORM_LIST.get(j).put("Type", "approved");
				} else {
					LOANFORM_LIST.get(j).put("Type", "rejected");
				}
			}
		}

		return false;
	}

	@Override
	public List<HashMap<String, Object>> ladViewForms(String planString) {

		int count = 0;
		for (int i = 0; i < LOANFORM_LIST.size(); i++) {
			if (planString.equalsIgnoreCase((String) LOANFORM_LIST.get(i).get("LoanType"))) {
				FORMS.add(LOANFORM_LIST.get(i));
			}
		}
		return FORMS;
	}

	@Override
	public List<HashMap<String, Object>> requestedForms() {
		if (LOANFORM_LIST.size() != 0) {
			for (int i = 0; i < LOANFORM_LIST.size(); i++) {
				if ("requested".equals((String) LOANFORM_LIST.get(i).get("LoanStatus"))) {
					REQUESTED_FORMS.add(LOANFORM_LIST.get(i));
				}
			}
			return REQUESTED_FORMS;
		} else
			return REQUESTED_FORMS;
	}
}
