package lambdapractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LamdaThreadPoolExample {

	
	public static void main(String[] args) {
		
		ExecutorService exe = Executors.newFixedThreadPool(5);
		
		MyLambda lambda=()->{
			System.out.println("Executing Dynamic code ...");
			for (int i = 0; i < 3; i++) {
				System.out.println("Dynamic Code Iteration "+(i+1));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	
		for (int i = 0; i < 10; i++) {
		exe.execute(()->lambda.display());
		}
		exe.shutdown();
	}
	
}
