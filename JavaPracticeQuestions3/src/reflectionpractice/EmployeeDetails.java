package reflectionpractice;

public class EmployeeDetails {
	
	private final String name;
	private int age;
	private static String designation;
	
	public EmployeeDetails(String name, int age, String designation) {
		super();
		this.name = name;
		this.age = age;
		this.designation = designation;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getName() {
		return name;
	}
	
	public void employeDesgnationDetails() {
		System.out.println(this.name +" is working in zoho application "+this.designation);
	}
	
	private void employeAgeDetails() {
		System.out.println(this.name +" is "+this.age+" years old");
	}
	
	private static void employeOfficeDetails(String office) {
		System.out.println("He is working in "+office+" as "+designation);
	}

}
