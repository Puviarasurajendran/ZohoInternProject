package topic3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ParallelThreadExample extends Thread {
	
	static int age=15;
	
	public ParallelThreadExample(String name) {
		super(name);
	}
	
	public void fetchAPIData() {
		
        try {
            // API endpoint URL
            String apiUrl = "https://dummy.restapiexample.com/api/v1/create";
            
            String jsonData ="{\"name\":\"vijay\",\"salary\":\"10000\",\"age\":\"22\"}";
            age++;
            String tem=""+age;
            jsonData=jsonData.replace("22",tem);
                    
            URL url = new URL(apiUrl);
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
          
            connection.setRequestMethod("POST");
            
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");	    	            
            connection.setDoOutput(true);
            connection.setDoInput(true);
            
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(jsonData.toString());
            outputStream.flush();
            outputStream.close();
            
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
            System.out.println(response.toString().replace(",", ",\n").replace("{", "{\r\n").replace("}", "\r}").replace("\\", ""));
            
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void run() {
		for (int i = 0; i < 3; i++) {
			
			System.out.println("Running..."+currentThread().getName());
			
			fetchAPIData();
		}
	}

}
