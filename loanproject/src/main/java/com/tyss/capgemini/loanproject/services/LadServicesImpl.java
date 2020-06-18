package com.tyss.capgemini.loanproject.services;

import com.tyss.capgemini.loanproject.exception.FormReviewChoiceException;
import com.tyss.capgemini.loanproject.util.FactoryClass;
import com.tyss.capgemini.loanproject.validation.Validation;

public class LadServicesImpl implements LadServices {
Validation validationClass = new Validation();
	
	@Override
	/**
	 * 
	 * @return
	 */
	public boolean viewLoanPrograms() {
		if (FactoryClass.getLadDao().viewLoanPrograms()) {
			return true;
		} else return false;
	}
	
	@Override
	/**
	 * 
	 * @param apid
	 * @param status
	 * @return
	 */
	public boolean ladReviewForms(String apid, String status) {
		if ((status.equalsIgnoreCase("approved")) || (status.equalsIgnoreCase("rejected"))) {
			FactoryClass.getLadDao().ladReviewForms(apid, status);
			return true;
		} else throw new FormReviewChoiceException("please write only approved or rejected.");
	}

	@Override
	/**
	 * 
	 * @param planString
	 * @return
	 */
	public boolean ladViewForms(String planString) {
		if (FactoryClass.getLadDao().ladViewForms(planString)) {
			return true;
		} else return false;
	}
	
	@Override
	/**
	 * 
	 * @return
	 */
	public boolean requestedForms() {
		if (FactoryClass.getLadDao().requestedForms()) {
			return true;
		} else return false;
	}

	@Override
	/**
	 * 
	 * @return
	 */
	public boolean loanTypes() {
		return FactoryClass.getLadDao().loanTypes();
	}

	@Override
	/**
	 * 
	 * @param k
	 * @return
	 */
	public String loanTypes(String k) {
		return  FactoryClass.getLadDao().loanTypes(k);
	}
	
	@Override
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean applicationExist(String id) {
		return FactoryClass.getLadDao().applicationExist(id);
	}
}
