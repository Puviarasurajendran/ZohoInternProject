package threadconcurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample implements Runnable {
	
	private CyclicBarrier barrier;
	private String name;
	
	

	public CyclicBarrierExample(CyclicBarrier barrier, String name) {
		this.barrier = barrier;
		this.name = name;
	}



	@Override
	public void run() {
		
		System.out.println("Started "+this.name);
		
		for (int i = 0; i < 100; i++) {
			 try {
				 
				barrier.await();
				System.out.println("Running  "+this.name);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	

}
