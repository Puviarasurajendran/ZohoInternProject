package streampackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamExample3 {

	public static void main(String[] args) {
		
		HashMap<String,String> student1 = new HashMap();
		     
		student1.put("Name","puvi");
		student1.put("dept","IT");
		student1.put("Course","B.tech");
		student1.put("year","5");
		
		HashMap<String,String> student2 = new HashMap();
		student2.put("Name","satha");
		student2.put("dept",null);
		student2.put("Course",null);
		student2.put("year","3");
		
		HashMap<String,String> student3 = new HashMap();
		student3.put("Name","Vijay");
		student3.put("dept",null);
		student3.put("Course",null);
		student3.put("year",null);
        
		HashMap<String,String> student4 = new HashMap();
		student4.put("Name",null);
		student4.put("dept",null);
		student4.put("Course",null);
		student4.put("year",null);
		
		ArrayList<HashMap<String,String>> al= new ArrayList<HashMap<String,String>>();
		
		al.add(student1);
		al.add(student2);
		al.add(student4);
		al.add(student3);
		
       Optional<HashMap<String, String>> ans = al.stream().max(Comparator.comparingLong(s -> s.values().stream().filter(v->v!=null).count()));
       
       System.out.println(ans);
       
       
       al = al.stream()
               .sorted(Comparator.comparing(HashMap::entrySet, 
                            (map1, map2) -> {
                                Iterator<Map.Entry<String, String>> iter1 = map1.iterator();
                                Iterator<Map.Entry<String, String>> iter2 = map2.iterator();
                                while (iter1.hasNext() && iter2.hasNext()) {
                                    Map.Entry<String, String> entry1 = iter1.next();
                                    Map.Entry<String, String> entry2 = iter2.next();
                                    int keyCompare = entry1.getKey().compareTo(entry2.getKey());
                                    if (keyCompare != 0) {
                                        return keyCompare;
                                    } else {
                                        int valueCompare = entry1.getValue().compareTo(entry2.getValue());
                                        if (valueCompare != 0) {
                                            return valueCompare;
                                        }
                                    }
                                }
                                return 0;
                            }))
               .collect(Collectors.toCollection(ArrayList::new));
       
       // Printing the sorted list
       al.forEach(System.out::println);
	   
	}
	
	
	
}
