package topic3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ThreadPoolExample implements Runnable {
	
	String name;

	public ThreadPoolExample(String name) {
		this.name = name;
	}
	
	public void run() {
		int i=0;
			
			getApidatas();
			i++;

	}
	
    void getApidatas() {
        try {
//        	System.out.println("-------------------------------\n");
        	
        	
        	
            URL url = new URL("https://fakestoreapi.com/products/1");
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            
            System.out.println(name+" Running .....");
            
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            System.out.println("Response Body:");
            System.out.println(response.toString().replace(",", ",\n"));
            connection.disconnect();
            System.out.println("-------------------------------\n");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
