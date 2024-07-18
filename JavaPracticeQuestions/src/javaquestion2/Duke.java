package javaquestion2;

public class Duke extends JavaMascot { 
	  void executeAction() { 
	    super.executeAction(); 
	    System.out.println("Duke is going to punch!"); 
	 
	  } 
	  
	  public static void main(String... superReservedWord) { 
	    new Duke().executeAction(); 
	  } 
	} 
