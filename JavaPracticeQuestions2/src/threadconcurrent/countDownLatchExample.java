package threadconcurrent;

import java.util.concurrent.CountDownLatch;

public class countDownLatchExample extends Thread {
    
	private CountDownLatch latch;
	private String name;
	
	public countDownLatchExample(CountDownLatch latch,String name) {
		this.name=name;
		this.latch = latch;
	}

	public void run() {
		
		System.out.println("started "+this.name);
		
		latch.countDown();
		
		for (int i = 0; i < 100; i++) {
			System.out.println("Running... "+this.name);
		}
	}
	
}
