package com.tyss.cg.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ThrowsKeywordClassExample {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties= new Properties();
		properties.load(new FileReader("application.properties"));
		System.out.println(properties.getProperty("name"));
		System.out.println("some code");
	}

}
