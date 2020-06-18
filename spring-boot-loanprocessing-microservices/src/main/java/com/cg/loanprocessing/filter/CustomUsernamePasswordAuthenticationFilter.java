package com.cg.loanprocessing.filter;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cg.loanprocessing.entity.LoanForm;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private LoanForm loanForm;

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
			loanForm = null;
			try {
				LoanForm loan = getLoanInfo(request);
				return loan.getEmail();
			} catch (IOException e) {

				e.printStackTrace();
				return "";
			}
		} // End of if

		return super.obtainUsername(request);
	}// End of obtainUsername()

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
			try {
				LoanForm loan = getLoanInfo(request);
				return loan.getPassword();
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}// end of if
		return super.obtainPassword(request);
	}// End of obtainPassword()

	private LoanForm getLoanInfo(HttpServletRequest request) throws IOException {
		if (loanForm == null) {
			ObjectMapper mapper = new ObjectMapper();
			String json = "";
			BufferedReader reader = request.getReader();
			while (reader.ready()) {
				json = json + reader.readLine();
			}
			loanForm = mapper.readValue(json, LoanForm.class);
		}
		return loanForm;

	}
}// End of class
