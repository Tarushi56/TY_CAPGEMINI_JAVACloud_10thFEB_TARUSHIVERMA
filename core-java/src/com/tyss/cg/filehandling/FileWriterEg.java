package com.tyss.cg.filehandling;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEg {
	public static void main(String[] args) throws IOException {
		try (FileWriter fileWriter = new FileWriter("newfile.txt")){
			fileWriter.write("This is the FileWriter example of writing data..!!");
			//fileWriter.append("This is the FileWriter example of writing data for the second time..!!");
			//fileWriter.write("MEOWWW!!");
			
			System.out.println("data has been written in file!!!!");
		} catch (Exception e) {
		}

	}
}


