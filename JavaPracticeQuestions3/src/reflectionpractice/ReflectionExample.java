package reflectionpractice;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {

	public static void main(String[] args) {
		try {
		EmployeeDetails emd= new EmployeeDetails("Puvi", 22, "Developer");
		
	     Field[] employefeilds=emd.getClass().getDeclaredFields();
	     Method[] employeMethod=emd.getClass().getDeclaredMethods();
		 
	     for (Field field : employefeilds) {
//			System.out.println(field.getName());
			if(field.getName().equalsIgnoreCase("name")) {
				field.setAccessible(true);
				field.set(emd, "Puviarasu");
			}
			if(field.getName().equalsIgnoreCase("age")) {
				field.setAccessible(true);
				field.set(emd, 23);
			}
		 }
	     
	     for (Method method : employeMethod) {
			System.out.print(method.getName()+" ");
			if(method.getName().equalsIgnoreCase("employeAgeDetails")) {
				method.setAccessible(true);
                method.invoke(emd);				
			}
			if(method.getName().equalsIgnoreCase("employeOfficeDetails")) {
				method.setAccessible(true);
                method.invoke(null,"zoho");				
			}
		}
	     System.out.println("name "+emd.getName()+" is Age "+emd.getAge()+" "+emd.getDesignation());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
