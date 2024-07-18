package typearguments;

import java.util.ArrayList;
import java.util.List;

public class TypeArgumentTask {
	
	public void printListObject(List<Object> list) {
		System.out.println("Enter into method ListObject\n");
		
		for (Object obj: list) {
			System.out.println(obj);
		}
		System.out.println("");
	}
	
	public void printListWildCard(List<?> list) {
		System.out.println("Enter into method ListWildCard\n");
		
		for (Object obj: list) {
			System.out.println(obj);
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
		ArrayList al = new ArrayList(List.of("Puvi","Arasu","Raja","Vinayagam"));
		
		ArrayList<String> alStr = new ArrayList(List.of("Puvi","Arasu","Raja","Vinayagam"));
		
		TypeArgumentTask ta= new TypeArgumentTask();
		
		ta.printListObject(al);
		ta.printListWildCard(al);
		
//		ta.printListObject(alStr);
		ta.printListWildCard(alStr);
		
	}

}
