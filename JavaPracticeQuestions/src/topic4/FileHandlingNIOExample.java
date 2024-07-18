package topic4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import topic3.CurrentDateTime;

public class FileHandlingNIOExample {
	
	
	
	public void ReadWriteFiles(){
		try {
		
		Path p = Paths.get("/home/admin/Documents/demo1.txt");
		
		Path p1 = Paths.get("/home/admin/Documents/ExampleNIOFiles.txt");
		
		if(!Files.exists(p1)) {
			Path filepath=Files.createFile(p1);
		}
		
		List<String> lines=Files.readAllLines(p);    
		
		for (String str : lines) {
			String tem=str.toUpperCase();
	        Files.write(p1, tem.getBytes(),StandardOpenOption.APPEND);
	        Files.write(p1,System.getProperty("line.separator").getBytes(),StandardOpenOption.APPEND);
		}
		System.out.println("Example NIO file created Successfully ");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void copyFileToReqpath() {
		try {
			

		System.out.println("File coping : ");
		
		Path source = Paths.get("/home/admin/Downloads/EmployeDeatils.xml");
		Path designation = Paths.get("/home/admin/Documents/EmployeeRecords.xml");
		
		Files.copy(source, designation);
		
		System.out.println("Saved Completed : ");
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public static void main(String[] args) {
		
		FileHandlingNIOExample fnio = new FileHandlingNIOExample();
		
//		fnio.ReadWriteFiles();
		
		fnio.copyFileToReqpath();
		
	}

}
