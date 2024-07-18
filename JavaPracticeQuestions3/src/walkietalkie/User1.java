package walkietalkie;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class User1 extends Thread {

		ServerSocket serverSocket;
		
		DataInputStream dataInput;
		DataOutputStream dataOutput;
		Scanner sc;
		
		public User1() {
		  try {
			  
			  serverSocket= new ServerSocket(9909);
			  
			  Socket socket= serverSocket.accept();
			  
		  dataInput= new DataInputStream(socket.getInputStream());
		  dataOutput= new DataOutputStream(socket.getOutputStream());
		  
		  this.start();
//		  this.setDaemon(true);
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
	                        System.out.println("user 2 : " + msg);
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
//		            System.out.println("user 1 : " + message);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    public static void main(String[] args) {
		        User1 server = new User1();
		        Scanner scanner = new Scanner(System.in);
		        StringBuilder sb= new StringBuilder();
		        while (true) {
		            String message = scanner.nextLine();
		            sb.append(message+"\n");
		            String tem=message.toLowerCase();
		            if(tem.contains("overandoff")) {
		            	  server.sendMessage(sb.toString());
		            	  System.exit(0);
		            }
		            else if(tem.contains("over")) {
		            server.sendMessage(sb.toString());
		            }
		        }
		    }
		}
		
