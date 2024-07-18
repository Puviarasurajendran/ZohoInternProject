package collectionspractice;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionExample2 {
	
	public static void main(String[] args) {
		
		LinkedList number= new LinkedList(List.of(4,2,3,7,1,8,2,5,3));
		
		System.out.println("LinkedList :"+number);
		
		TreeSet sortedNum= new TreeSet(number);
		
		System.out.println("Tree set :"+sortedNum);
		
		LinkedHashSet lhs= new LinkedHashSet(number);
		
		System.out.println("Linked hashSet :"+lhs);

		TreeMap sortedMap= new TreeMap();
		
		sortedMap.put("name", "Puvi");
		sortedMap.put("Age", 21);
		sortedMap.put("Course","B.tech");
		
		System.out.println("Tree Map : "+sortedMap);
		
	}

}
