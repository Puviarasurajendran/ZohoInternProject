package streampackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamExample2 {

	public static void main(String[] args) {

		StudentDetails sd1 = new StudentDetails("Puvi", 23, "B.tech", "IT");

		StudentDetails sd2 = new StudentDetails("Satha", 23, null, null);

		StudentDetails sd3 = new StudentDetails("Vijay", 0, null, "IT");

		StudentDetails sd4 = new StudentDetails(null, 0, null, null);

		StudentDetails sd5 = new StudentDetails("Ram", 23, null, "IT");
		
		

		List<StudentDetails> students = new ArrayList();

		students.add(sd1);
		students.add(sd2);
		students.add(sd3);
		students.add(sd4);
		students.add(sd5);
		
		

//		students.forEach(s->System.out.println(s));	

		Optional<StudentDetails> ans = students.stream()
				        .max(Comparator.comparingLong(student -> 
				         Stream.of(student.getName(), student.getAge(), student.getCourse(), student.getDept())
						.filter(field -> field != null).count()));

		System.out.println(ans);
	}
}
