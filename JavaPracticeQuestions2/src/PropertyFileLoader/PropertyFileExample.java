package PropertyFileLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileExample {

	 public static void main(String[] args) {
	        Properties prop = new Properties();
	        InputStream input = null;

	        try {
	        	input = new FileInputStream("src/configuration.properties");
	            prop.load(input);

	            System.out.println("Database URL: " + prop.getProperty("dburl"));
	            System.out.println("Database Username: " + prop.getProperty("username"));
	            System.out.println("Database Password: " + prop.getProperty("password"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } finally {
	            if (input != null) {
	                try {
	                    input.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}
