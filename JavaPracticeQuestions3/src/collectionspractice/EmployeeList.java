package collectionspractice;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

	private String name;
	private int age;
	private String course;
	private String collage;
	private List<String> skills;

	public EmployeeList(String name, int age, String course, String collage, List<String> skills) {
		this.name = name;
		this.age = age;
		this.course = course;
		this.collage = collage;
		this.skills = skills;
	}
    
	
	public EmployeeList() {
		
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCollage() {
		return collage;
	}

	public void setCollage(String collage) {
		this.collage = collage;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<EmployeeList> addEmployees() {
		List<EmployeeList> employeeList = new ArrayList<EmployeeList>();

		EmployeeList emp1 = new EmployeeList("Puviarasu", 23, "B.tech", "AUBIT",List.of("Java", "DSA", "JAVA SCRIPT", "React"));
		EmployeeList emp2 = new EmployeeList("Sathasivam", 24, "BE", "AUBIT", List.of("Php", "python", "JAVA SCRIPT"));
		EmployeeList emp3 = new EmployeeList("Vijay", 25, "BE", "AUBIT", List.of(".Net", "Sales Force", "HTML"));
		EmployeeList emp4 = new EmployeeList("Theeran", 21, "B.tech", "AUBIT",List.of("Java", "DSA", "Python", "React"));

		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		employeeList.add(emp4);

		return employeeList;
	}

	@Override
	public String toString() {
		return "EmployeeList [name=" + name + ", age=" + age + ", course=" + course + ", collage=" + collage
				+ ", skills=" + skills + "]";
	}

}
