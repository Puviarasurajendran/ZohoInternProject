package topic3;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTask {
	
	public static void main(String[] args) {
		
		ExecutorService es= Executors.newFixedThreadPool(7);
		
		String[] userThreads= {"MyThread 1","MyThread 2","MyThread 3","Mythread 4","Mythread 5","Mythread 6","Mythread 7"};
		
	    for (String name : userThreads) {
			es.execute(new ThreadPoolExample(name));
		}
	    es.shutdown();
	}

}
