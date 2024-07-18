package topic3;

public class ThreadExample {
	
	
	public static void main(String[] args) throws InterruptedException {
		
//		ReadFileContent rfc= new ReadFileContent();
//		rfc.start();
		
		ParallelThreadExample pte1= new ParallelThreadExample("MyThread 1 ");
		ParallelThreadExample pte2= new ParallelThreadExample("MyThread 2 ");
		pte1.start();
		pte1.join();
		pte2.start();
		
	}

}
