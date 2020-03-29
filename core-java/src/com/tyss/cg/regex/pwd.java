package com.tyss.cg.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pwd {
	
 private Pattern p;
 private Matcher m;
 
 String pass_pattern="((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40}";
 Pattern p1 = Pattern.compile(pass_pattern);
 
 public boolean validate(final String password) {
	 m = p.matcher(password);
	 return m.matches();
 }
}
