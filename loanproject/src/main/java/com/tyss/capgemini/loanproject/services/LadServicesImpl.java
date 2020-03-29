package com.tyss.capgemini.loanproject.services;

import java.util.HashMap;
import java.util.List;
import static com.tyss.capgemini.loanproject.util.FactoryClass.*;

public class LadServicesImpl implements LadServices {
	@Override
	public List<HashMap<String, Object>> viewLoanPrograms() {
		return getLadDAO().viewLoanPrograms();
	}

	@Override
	public boolean ladReviewForms(String apid, String status) {
		if (getLadDAO().ladReviewForms(apid, status)) {
			return true;
		} else
			return false;
	}

	@Override
	public List<HashMap<String, Object>> ladViewForms(String planString) {
		return getLadDAO().viewLoanPrograms();
	}

	@Override
	public List<HashMap<String, Object>> requestedForms() {
		return getLadDAO().requestedForms();
	}
}
