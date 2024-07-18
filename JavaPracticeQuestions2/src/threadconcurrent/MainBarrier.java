package threadconcurrent;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainBarrier {
	
	public static void main(String[] args) {
		
		 try {
			 
				ExecutorService exe= Executors.newFixedThreadPool(4);
				
			    CyclicBarrier barrier= new CyclicBarrier(3);
			    
			    exe.submit(new CyclicBarrierExample(barrier,"Thread 1"));
			    exe.submit(new CyclicBarrierExample(barrier,"Thread 2"));
			    exe.submit(new CyclicBarrierExample(barrier,"Thread 3"));
			    
			    exe.shutdown();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				 System.out.println("All threads are completed successfully");
			}
	}

