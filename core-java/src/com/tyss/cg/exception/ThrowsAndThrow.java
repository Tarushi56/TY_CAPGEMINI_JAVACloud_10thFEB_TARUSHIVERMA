package com.tyss.cg.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ThrowsAndThrow {
	public static void main(String[] args) throws FileNotFoundException, IOException {
	new Properties().load(new FileReader("application.properties"));
	System.out.println("some code");
	}
}
 