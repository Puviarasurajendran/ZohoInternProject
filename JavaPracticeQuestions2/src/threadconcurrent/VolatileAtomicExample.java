package threadconcurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAtomicExample extends Thread {
	
	int count;
	volatile int countVal;
	AtomicInteger countAtomic;
    String name;
    
    
	public VolatileAtomicExample() {
		
		this.countAtomic=new AtomicInteger();
		countVal=0;
		count=0;
	}


	@Override
	public void run() {
		
//		for (int i = 0; i < 10000; i++) {
		   while(true) {
			countVal++;
			countAtomic.incrementAndGet();
			count++;
			
			 System.out.println("Integer :"+this.count+" volatile :"+this.countVal +" Atomic Integer : "+this.countAtomic+" ----->"+currentThread().getName());
		}
	   
	}
	
	
	public static void main(String[] args) {
		
		VolatileAtomicExample vae= new VolatileAtomicExample();
		 try {
			
			 ExecutorService exe= Executors.newFixedThreadPool(5);
			 String threads[]= {"thread 1","thread 2","thread 3","thread 4","thread 5","thread 6","thread 7","thread 8","thread 9","thread 10"};
			
	         for (int i = 0; i < 10; i++) {
	        	 
				exe.execute(vae);
			}
//	         exe.shutdown();
			 
//			 Thread t1= new Thread(new VolatileAtomicExample("thread 1"));
//			 Thread t2= new Thread(new VolatileAtomicExample("thread 2"));
//			 Thread t3= new Thread(new VolatileAtomicExample("thread 3"));
//			 Thread t4= new Thread(new VolatileAtomicExample("thread 4"));
//			 Thread t5= new Thread(new VolatileAtomicExample("thread 5"));
//			 Thread t6= new Thread(new VolatileAtomicExample("thread 6"));
//			 
//			 t1.start();
//			 t2.start();
//			 t3.start();
//			 t4.start();
//			 t5.start();
//			 t6.start();
		} catch (Exception e) {
			e.printStackTrace();
		};
		
//	     System.out.println("volatile :"+vae.countVal +" Atomic Integer : "+vae.countAtomic);
	}
}
