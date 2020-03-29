package com.tyss.cg.filehandling;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileEg {
	public static void main(String[] args) {
		try {
			Properties properties = new Properties();
			properties.load(new FileReader("application.properties"));
			System.out.println(properties.getProperty("name"));
			properties.setProperty("batch", "Java Cloud");
			System.out.println(properties.getProperty("batch"));
			//System.out.println(properties.getProperty("batch"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
