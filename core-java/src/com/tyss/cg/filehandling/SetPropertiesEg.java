package com.tyss.cg.filehandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class SetPropertiesEg {
	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		properties.put("batch", "Java cloud");
		properties.put("Tech", "Web basics, Java-Full stack, Java Framework");
		properties.put("Strength", "25");
		properties.store(new FileWriter("batch.properties"), "Batch-details");
		System.out.println("properties file created");
	}
}
