package com.tyss.capgemini.loanproject.services;

public interface LadServices {
	/**
	 * 
	 * @return
	 */
	public boolean viewLoanPrograms();
	/**
	 * 
	 * @param apid
	 * @param status
	 * @return
	 */
	public boolean ladReviewForms(String apid, String status);
	/**
	 * 
	 * @param planString
	 * @return
	 */
	public boolean ladViewForms(String planString);
	/**
	 * 
	 * @return
	 */
	public boolean requestedForms();
	/**
	 * 
	 * @return
	 */
	public boolean loanTypes();
	/**
	 * 
	 * @param k
	 * @return
	 */
	public String loanTypes(String k);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean applicationExist(String id);
}
