package calculatorpro;

import java.util.ArrayList;
import java.util.Scanner;

import calculatorpro.Calculator.CalciDouble;
import calculatorpro.Calculator.CalciInt;

public class Calculate {
	
	abstract class Calci{
		
		void add(int a,int b) {
			System.out.println("Addition :"+(a+b));
		}
		
		abstract void add(double a,double b);
		
		void sub(int a,int b){
			System.out.println("Substraction :"+(a-b));
		}
		
		abstract void sub(double a,double b);
		
		void multi(int a,int b) {
			System.out.println("Multiplication :"+(a*b));
		}
		
		abstract void multi(double a,double b);
		
		void div(int a,int b) 
		{
			System.out.println("Division :"+(a/b));
		}
		abstract void div(double a,double b);
	}
	
	class CalciDouble extends Calci{

		@Override
		void add(double a, double b) {
			System.out.println("Addition :"+(a+b));
			
		}

		@Override
		void sub(double a, double b) {
			System.out.println("Substraction :"+(a-b));
			
		}

		@Override
		void multi(double a, double b) {
			
			System.out.println("Multiplication :"+(a*b));
		}

		@Override
		void div(double a, double b) {
			
			System.out.println("Division :"+(a/b));
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
    	ArrayList al= new ArrayList();
    	al.add(sc.next());
    	Calculate c= new Calculate();

    	
    	Calci calci= c.new CalciDouble();
//    	
//    	System.out.println("Enter S to stop calculator ");
//    	while(true) {
//    		String str=sc.next();
//    		
//    		if(str.equalsIgnoreCase("S")) break;
//    		
//    		else if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")) { 
//    			if(al.size()<2)al.add(str);
//    			else al.set(1, str);
//    		}
//    		
//    		else if(al.size()==2) {
//    			System.out.println("inside al size 2");
//    			String temp=str;
//    			
//    			double d=0;;
//    			int n=0;
//    			boolean flag=false;
//    			
//    			if(temp.contains(".")) {
//    				d=Double.parseDouble(temp);
//    				flag=true;
//    			}
//    			else {
//    				n=Integer.parseInt(temp);
//    				flag=false;
//    			}
//    			
//    			
//    			switch((String)al.get(1)) {
//    			
//    			case "+":
//    				calci.add(d, n)
//    				System.out.println(c.sum);
//    				al.set(0, ""+valAdd);
//    				break;
//    				
//    			case "-":
//    				double valSub=(flag)?calci.sub(d):calci.sub(n);
//     				System.out.println(c.sum);
//    				al.set(0, ""+valSub);
//    				break;
//    			
//    			case "*":
//    				double valmul=(flag)?calci.multi(d):calci.multi(n);
//    				System.out.println(c.sum);
//    				al.set(0, ""+valmul);
//    				break;
//    				
//    			case "/":
//    				double valDiv=(flag)?calci.div(d):calci.div(n);
//    				System.out.println(c.sum);
//    				al.set(0, ""+valDiv);
//    				break;
//    			
//    			 default:
//    				 System.out.println("Enter a correct operator");
//    				 
//    			}
//    		}
//    		
//    	}
    }
   
	

}
