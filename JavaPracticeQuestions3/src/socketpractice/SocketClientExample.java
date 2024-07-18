package socketpractice;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientExample {

	public static void main(String[] args) {
		
		try {
			
			Socket socket= new Socket("localhost",9090);
			
		    DataInputStream in= new DataInputStream(socket.getInputStream());
		    
		    String msg= in.readLine();
		    System.out.println("server says :"+msg);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
