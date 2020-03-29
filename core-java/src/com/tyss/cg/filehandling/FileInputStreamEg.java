package com.tyss.cg.filehandling;

import java.io.FileInputStream;

public class FileInputStreamEg {
	public static void main(String[] args) {
		 try (FileInputStream fileInputStream = new FileInputStream("p.jpg")){
			 int imgcode=0;
			 
			 while ((imgcode = fileInputStream.read())!=-1) {
				System.out.print((char)imgcode);
			}
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}

}
