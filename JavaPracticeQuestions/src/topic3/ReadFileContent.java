package topic3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFileContent extends Thread {
	
	
	public void run(){
		
		while(true) {
		
		try {
			
			FileReader fr= new FileReader("/home/admin/Documents/samplefile");
			FileWriter fw= new FileWriter("/home/admin/Documents/Testfile.txt");
		      int i;    
	          try {
	        	   
				while((i=fr.read())!=-1){   
				     if(i>=97&&i<=122) i-=32;
				     System.out.print((char)i);
				     fw.write(i);
				  }
				fr.close();
				fw.close();
				Thread.sleep(20000);
				
			} catch (IOException e) {

				e.printStackTrace();
			}
	          
			
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
 }
}
