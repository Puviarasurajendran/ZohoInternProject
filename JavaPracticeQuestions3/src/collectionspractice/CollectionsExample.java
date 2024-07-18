package collectionspractice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CollectionsExample {
	
	public void jsonFileCreate(List<EmployeeList> empList) {
		
		LinkedHashMap jsonDetails= new LinkedHashMap();
		ArrayList jsonDetailsList = new ArrayList();
		
		for (EmployeeList emp : empList) {
			LinkedHashMap employee = new LinkedHashMap();
			employee.put("Name", emp.getName());
			employee.put("Age", emp.getAge());
			employee.put("Course", emp.getCourse());
			employee.put("Collage", emp.getCollage());
			employee.put("Skills", emp.getSkills());
			
			jsonDetailsList.add(employee);
		}
		jsonDetails.put("Employees", jsonDetailsList);
		
		 Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(jsonDetailsList);
        
        String filePath="/home/admin/Documents/EmployeeList.json";
        
        try (FileWriter fileWriter = new FileWriter(filePath)) {
           
            fileWriter.write(json);
            
            System.out.println("JSON file created: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		
		EmployeeList empl= new EmployeeList();
		
		List<EmployeeList> employessList=empl.addEmployees();
		
		CollectionsExample ce= new CollectionsExample();
		
		ce.jsonFileCreate(employessList);
		
		
	}

}
