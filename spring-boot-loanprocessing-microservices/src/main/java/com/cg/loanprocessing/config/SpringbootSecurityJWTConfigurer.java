package com.cg.loanprocessing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cg.loanprocessing.BootAuthenticationEntryPoint;
import com.cg.loanprocessing.filter.JwtRequestFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringbootSecurityJWTConfigurer extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

	@Autowired
	private BootAuthenticationEntryPoint bootAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService);

	} // End of configureGlobal()

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/api/login","/api/form/add","/api/changepassword/{email}/{password}").permitAll().and()
		    .authorizeRequests().antMatchers("/api/client","/api/client/add","/api/client/update","/api/client/delete/{email}","/api/loan","/api/loan/add-loan","/api/loan/delete/{type}",
		    		"/api/loanapplication","/api/loanapplicationapprove/{appId}","/api/loanapplicationreject/{appId}",
		    		"/api/loanapplication/{loanapplication}",
		    		"/api/loanapplication").hasRole("ADMIN")
		    .and()
		    .authorizeRequests().antMatchers("/api/form/add","/api/form/{formId}").permitAll()
	    .and()
		    .authorizeRequests().antMatchers("/api/form").hasAnyRole("ADMIN","LAD")
//		    .and()
//		    .authorizeRequests().antMatchers("/api/form").hasRole("LAD")
//		    .and()
//		    .authorizeRequests().antMatchers("/api/form/add").hasRole("CUSTOMER")
		    .and()
		    .authorizeRequests().antMatchers("/api/getCustomer/{pageNo}/{itemsPerPage}").permitAll()
			.and()
			.authorizeRequests().antMatchers("/api/getSortCustomer/{pageNo}/{itemsPerPage}/{fieldName}").permitAll()
			.and()
		    .authorizeRequests().antMatchers("/api/loanapplicationapprove/{appId}"
		    		,"/api/loanapplicationreject/{appId}","/api/loan/delete/{type}").hasRole("LAD")
		    .anyRequest().authenticated()
		    .and()
				.exceptionHandling().authenticationEntryPoint(bootAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}// End of configure()

}// end of class

