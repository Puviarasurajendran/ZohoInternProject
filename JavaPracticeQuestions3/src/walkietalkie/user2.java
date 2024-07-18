package walkietalkie;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class user2 extends Thread {

	Socket socket;
	
	DataInputStream dataInput;
	DataOutputStream dataOutput;
	Scanner sc;
	
	public user2() {
	  try {
		  
	  socket= new Socket("localhost",9909);
		
	  dataInput= new DataInputStream(socket.getInputStream());
	  dataOutput= new DataOutputStream(socket.getOutputStream());
	  
	  this.start();

	  
	}
	  catch(Exception e) {
		e.printStackTrace();
	}
}
	
    public void run() {
        try {
            while (true) {
                if (dataInput.available() > 0) {
                    String msg = dataInput.readUTF();

                        System.out.println("user 1 : " + msg);

                } else {
                    Thread.sleep(100);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
	
	  public void sendMessage(String message) {
	        try {
	            dataOutput.writeUTF(message);
	            dataOutput.flush();
//	            System.out.println("user 2 : " + message);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        user2 client = new user2();
	        Scanner scanner = new Scanner(System.in);
	       
	        StringBuilder sb= new StringBuilder();
	        while (true) {
	            String message = scanner.nextLine();
	            sb.append(message+"\n");
	            String tem=message.toLowerCase();
	            if(tem.contains("overandoff")) {
	            	client.sendMessage(sb.toString());
	            	  System.exit(0);
	            }
	            else if(tem.contains("over")) {
	            	client.sendMessage(sb.toString());
	            }
	        }
	    }
		
	}
	
