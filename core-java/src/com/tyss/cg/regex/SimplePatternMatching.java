package com.tyss.cg.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimplePatternMatching {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\d"); // for matching single digit 0-9 
		Matcher matcher = p.matcher("6");
		
		System.out.println(matcher.matches());
	}

}
