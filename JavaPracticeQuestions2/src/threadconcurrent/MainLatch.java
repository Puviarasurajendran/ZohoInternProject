package threadconcurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainLatch {

	
	public static void main(String[] args) {
		
		 try {
			 
		ExecutorService exe= Executors.newFixedThreadPool(4);
		
	    CountDownLatch latch= new CountDownLatch(3);
 
	    exe.submit(new countDownLatchExample(latch,"Thread 1"));
	    exe.submit(new countDownLatchExample(latch,"Thread 2"));
	    exe.submit(new countDownLatchExample(latch,"Thread 3"));
	    
	    latch.await();
	    
	    exe.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 System.out.println("All threads are completed successfully");
	}
}
