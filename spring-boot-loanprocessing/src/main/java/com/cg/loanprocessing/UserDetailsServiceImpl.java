package com.cg.loanprocessing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.loanprocessing.entity.LoanForm;
import com.cg.loanprocessing.service.LoanFormService;

import lombok.Data;
@Data
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private LoanFormService loanFormService;
	public static LoanForm loanForm; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl();
		userDetailsImpl.setLoanForm(loanFormService.searchByEmail(username));
	//	UsernameNotFoundException("User not found");
		return userDetailsImpl ;
	}
}
