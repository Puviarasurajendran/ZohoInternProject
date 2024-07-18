package streampackage;

public class StudentDetails {
	
	
	String name;
	int age;
	String course;
	String dept;
	
	public StudentDetails(String name, int age, String course, String dept) {
		this.name = name;
		this.age = age;
		this.course = course;
		this.dept = dept;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + ", course=" + course + ", dept=" + dept + "]";
	}
	
	
	
}
