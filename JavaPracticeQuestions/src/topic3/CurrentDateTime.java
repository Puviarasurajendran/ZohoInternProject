package topic3;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateTime extends Thread {
	
	public  void run() {
		while(true) {
		  try {
			  
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
		   Thread.sleep(2000);
		  }
		  catch(InterruptedException e) {
			  e.printStackTrace();
		  }
		}
	}
	
	  public static void main(String[] args) {   
		   
		  CurrentDateTime th= new CurrentDateTime();
		  th.start();
		  }
	  }    
	  