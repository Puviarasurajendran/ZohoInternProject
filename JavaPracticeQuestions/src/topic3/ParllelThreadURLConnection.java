package topic3;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ParllelThreadURLConnection {

	    public static void getApidatas() {
	        try {
	        	
	            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
	            
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            
	            connection.setRequestMethod("GET");
	            
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
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public static void fetchDataPostMethod() {
	    	
	    	        try {
	    	            // API endpoint URL
	    	            String apiUrl = "https://dummy.restapiexample.com/api/v1/create";
	    	            
	    	            String jsonData ="{\"name\":\"satha\",\"salary\":\"15000\",\"age\":\"21\"}";
	    	                    
	    	            URL url = new URL(apiUrl);
	    	            
	    	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    	            
	    	          
	    	            connection.setRequestMethod("POST");
	    	            
	    	            connection.setRequestProperty("Content-Type", "application/json");
	    	            connection.setRequestProperty("Accept", "application/json");	    	            
	    	            connection.setDoOutput(true);
//	    	            connection.setDoInput(true);
	    	            
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
	    
	    public static void fetchOwnApidata() {
	    	
	        try {
	            // API endpoint URL
	            String apiUrl = "http://localhost:8080/StrutsCustomersFetchApi/customer/createCustomer";
	            
	            String jsonData ="{\n"
	            		+ "    \"age\": 25,\n"
	            		+ "    \"country\": \"India\",\n"
	            		+ "    \"email\": \"veera@zoho.com\",\n"
	            		+ "    \"firstName\": \"Veera\",\n"
	            		+ "    \"id\": 8,\n"
	            		+ "    \"lastName\": \"Kumar\"\n"
	            		+ "  }";
	                    
	            URL url = new URL(apiUrl);
	            
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            
	          
	            connection.setRequestMethod("POST");
	            
	            connection.setRequestProperty("Content-Type", "application/json");
	            connection.setRequestProperty("Accept", "application/json");	    	            
	            connection.setDoOutput(true);
//	            connection.setDoInput(true);
	            
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
	    
	    public static void main(String[] args) {
			
	    	ParllelThreadURLConnection thc= new ParllelThreadURLConnection();
	    	
	    	thc.fetchOwnApidata();
	    	
		}
	    	

	    	
	    	
	    }
	

