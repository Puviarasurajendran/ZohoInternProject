package lambdapractice;

public class LambdaDemo {

   int count1=0;
   
   public void method1() {
	   
	   
	  int count2=2;

	   MyLambda m= ()->{
		 System.out.println("Hai Zoho");
		 System.out.println(count1++);
		 System.out.println(count2);
	   };
	   
	   m.display();
	   m.display();
   }	
   
   public static void main(String[] args) {
	
	   LambdaDemo ld= new LambdaDemo();
	   ld.method1();
	   
}
}
