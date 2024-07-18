package calculatorpro;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator{
	double sum =0;

class CalciDouble{
	
	double add(double d) {
		return sum+=d;
	}
	
	double sub(double d) {
		return sum-=d;
	}
	
	double multi(double d) {
		return sum*=d;
	}
	double div(double d) {
		return sum/=d;
	}
}

class CalciInt extends CalciDouble{
	
	double add(int d) {
		return sum+=d;
	}
	
	double sub(int d) {
		return sum-=d;
	}
	
	double multi(int d) {
		return sum*=d;
	}
	double div(int d) {
		return sum/=d;
	}
}

   public static void main(String[] args) {
	
		Scanner sc= new Scanner(System.in);
    	ArrayList al= new ArrayList();
    	al.add(sc.next());
    	Calculator c= new Calculator();
    	c.sum=Double.parseDouble((String) al.get(0));
    	
    	CalciDouble calci= c.new CalciInt();
    	
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
    				double valAdd=(flag)?calci.add(d):calci.add(n);
    				System.out.println(c.sum);
    				al.set(0, ""+valAdd);
    				break;
    				
    			case "-":
    				double valSub=(flag)?calci.sub(d):calci.sub(n);
     				System.out.println(c.sum);
    				al.set(0, ""+valSub);
    				break;
    			
    			case "*":
    				double valmul=(flag)?calci.multi(d):calci.multi(n);
    				System.out.println(c.sum);
    				al.set(0, ""+valmul);
    				break;
    				
    			case "/":
    				double valDiv=(flag)?calci.div(d):calci.div(n);
    				System.out.println(c.sum);
    				al.set(0, ""+valDiv);
    				break;
    			
    			 default:
    				 System.out.println("Enter a correct operator");
    				 
    			}
    		}
    		
    	}
    }
   
   
   }
	