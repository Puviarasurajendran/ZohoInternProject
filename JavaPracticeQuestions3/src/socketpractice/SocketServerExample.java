package socketpractice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExample {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket= new ServerSocket(9090);
			Socket socket=serverSocket.accept();
			
			DataOutputStream out= new DataOutputStream(socket.getOutputStream());
			String msg="Hai ZOHO Developer";
			out.write(msg.getBytes());
			out.flush();
			out.close();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}

}
