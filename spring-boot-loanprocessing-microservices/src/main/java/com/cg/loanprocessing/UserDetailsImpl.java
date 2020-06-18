package com.cg.loanprocessing;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.cg.loanprocessing.entity.LoanForm;

import lombok.Data;

@Data
@Component
public class UserDetailsImpl implements UserDetails{

	private LoanForm loanForm;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(loanForm.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return loanForm.getPassword();
	}

	@Override
	public String getUsername() {
		return loanForm.getEmail();
	}
	
	public String getEmail() {
		return loanForm.getEmail();
	}
	public int getLoanId() {
		return loanForm.getLoanId();
	}
	public String getRole() {
		return loanForm.getRole();
	}
	public String getFullName() {
		return loanForm.getFullName();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}// end of class

