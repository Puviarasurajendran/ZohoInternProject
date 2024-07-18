package topic4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.SequenceInputStream;

public class FileHandlingExample {

	public void filehandle() {
		
		try {
			FileInputStream fis1= new FileInputStream("/home/admin/Documents/samplefile");
			
			FileInputStream fis2= new FileInputStream("/home/admin/Documents/demo.txt");
			
			FileOutputStream fos = new FileOutputStream("/home/admin/Documents/designation.txt");
			
			SequenceInputStream sis= new SequenceInputStream(fis1, fis2);
			int b;
			
			  while ((b=sis.read()) != -1) {
				  fos.write((char)b);
	            }
			  System.out.println("Designation File generated successfully...");
			  fis1.close();
			  fis2.close();
			  fos.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		 catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public static void main(String[] args) {
		
		FileHandlingExample fhe= new FileHandlingExample();
		fhe.filehandle();
	}
	
	
}
