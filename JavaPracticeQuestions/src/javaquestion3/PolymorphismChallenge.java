package javaquestion3;

import java.util.Scanner;

public class PolymorphismChallenge { 
	
    static abstract class Simpson { 
        void talk() { 
            System.out.println("Simpson!"); 
        } 
        protected void prank(String prank) { 
            System.out.println(prank); 
        } 
    } 
    
    
    static class Bart extends Simpson { 
        String prank; 
        Bart(String prank) { this.prank = prank; } 
        protected void talk() { 
            System.out.println("Eat my shorts!"); 
        } 
        protected void prank() { 
            super.prank(prank); 
            System.out.println("Knock Homer down"); 
        } 
    } 
    
    static class Lisa extends Simpson { 
        void talk(String toMe) { 
            System.out.println("I love Sax!"); 
        } 
    } 
    
    
    public static void main(String... doYourBest) { 
//        new Lisa().talk("Sax :)"); 
//        Simpson simpson = new Bart("D'oh"); 
//        simpson.talk(); 
//        Lisa lisa = new Lisa(); 
//        lisa.talk(); 
//        ((Bart) simpson).prank(); 
    	
    	Scanner sc = new Scanner(System.in);
    	StringBuilder sb= new StringBuilder();
        while(true) {
    	String ans= sc.nextLine();
    	sb.append(ans);
    	sb.append("\n");
    	
    	 if(ans.contains("overandoff")) {
    		System.exit(0);
    	}
    	 else if(ans.contains("over")) {
     		System.out.println(sb);
     		System.out.println("conversation over");
     	}
        }
    	
    } 
} 
