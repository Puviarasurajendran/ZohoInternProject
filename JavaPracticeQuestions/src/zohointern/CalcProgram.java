package zohointern;

import java.util.ArrayList;
import java.util.Scanner;

public class CalcProgram {
	
	static double sum=0;
	
	public static double add(int n) {
		return sum+=n;
	}
	
	public static double add(double d) {
		return sum+=d;
		
	}
	public static double sub(double d) {
		return sum-=d;
		
	}
	public static double sub(int n) {
		return sum-=n;
		
	}
	public static double multi(int n) {
		return sum*=n;
		
	}
	public static double multi(double d) {
		return sum*=d;
		
	}
	
	public static double div(int n) {
		return sum/=n;
		
	}
	public static double div(double d) {
		return sum*=d;
	}
    
    public static void main(String[] args) {
    	
    	System.out.println("--------------------------------");
//    	String s="zoho";
//    	String s1="zoho";
//    	String a= new String("zoho");
//    	System.out.println("s==s1 "+(s==s1));
//    	System.out.println("s==a "+(s==a));
    	
    	Scanner sc= new Scanner(System.in);
    	ArrayList al= new ArrayList();
    	al.add(sc.next());
    	sum=Double.parseDouble((String) al.get(0));
    	System.out.println("Enter S to stop calculator ");
    	while(true) {
    		String str=sc.next();
    		
    		if(str.equalsIgnoreCase("S")) break;
    		
    		else if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")) { 
    			if(al.size()<2)al.add(str);
    			else al.set(1, str);
    		}
    		
    		else if(al.size()==2) {
    			System.out.println("inside al size 2");
    			String temp=str;
    			
    			double d=0;;
    			int n=0;
    			boolean flag=false;
    			
    			if(temp.contains(".")) {
    				d=Double.parseDouble(temp);
    				flag=true;
    			}
    			else {
    				n=Integer.parseInt(temp);
    				flag=false;
    			}
    			
    			
    			switch((String)al.get(1)) {
    			
    			case "+":
    				double valAdd=(flag)?add(d):add(n);
    				System.out.println(sum);
    				al.set(0, ""+valAdd);
    				break;
    				
    			case "-":
    				double valSub=(flag)?sub(d):sub(n);
     				System.out.println(sum);
    				al.set(0, ""+valSub);
    				break;
    			
    			case "*":
    				double valmul=(flag)?multi(d):multi(n);
    				System.out.println(sum);
    				al.set(0, ""+valmul);
    				break;
    				
    			case "/":
    				double valDiv=(flag)?div(d):div(n);
    				System.out.println(sum);
    				al.set(0, ""+valDiv);
    				break;
    			
    			 default:
    				 System.out.println("Enter a correct operator");
    				 
    			}
    		}
    		
    	}
    }

}
