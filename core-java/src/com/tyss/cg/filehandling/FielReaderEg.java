package com.tyss.cg.filehandling;

import java.io.FileReader;

public class FielReaderEg {
	public static void main(String[] args) {
		try (FileReader fileReader = new FileReader("newfile.txt")) {
			int charUnicode;
			while ((charUnicode = fileReader.read()) != -1) {
				System.out.print((char)charUnicode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
