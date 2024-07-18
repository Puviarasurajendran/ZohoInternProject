package streampackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample4 {

	public static void main(String[] args) {

		HashMap<String, String> student1 = new HashMap();

		student1.put("Name", "puvi");
		student1.put("dept", "IT");
		student1.put("Course", "BTech");
		student1.put("year", "5");

		HashMap<String, String> student2 = new HashMap();
		student2.put("Name", "satha");
		student2.put("dept", "CSE");
		student2.put("Course", "BE");
		student2.put("year", "3");

		HashMap<String, String> student3 = new HashMap();
		student3.put("Name", "Vijay");
		student3.put("dept", "IT");
		student3.put("Course", "BE");
		student3.put("year", "1");

		HashMap<String, String> student4 = new HashMap();
		student4.put("Name", "Ajith");
		student4.put("dept", "IT");
		student4.put("Course", "BE");
		student4.put("year", "2");

		ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String, String>>();

		al.add(student1);
		al.add(student2);
		al.add(student4);
		al.add(student3);

		List sortedList = al.stream().flatMap(map -> map.entrySet().stream())
				.sorted(Comparator.comparing(Map.Entry<String, String>::getKey).
						thenComparing(Map.Entry::getValue))
				.collect(Collectors.toList());

		// Printing the sorted list
		sortedList.forEach(System.out::println);

	}
}
