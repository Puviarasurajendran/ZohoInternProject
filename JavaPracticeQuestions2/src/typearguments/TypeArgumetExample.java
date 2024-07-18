package typearguments;

import java.util.ArrayList;
import java.util.List;

public class TypeArgumetExample {
	
	public  <T> List<T> filterBytype(List<Object> list, Class<T> type){
		
		List<T> filteredList= new ArrayList<T>();
		
        for (Object obj : list) {
        	
        	if(type.isInstance(obj)) {
        		
        		filteredList.add(type.cast(obj));
        	}
		}
		return filteredList;
	}
	
	
	public static void main(String[] args) {
		
		TypeArgumetExample tae= new TypeArgumetExample();
		List al = new ArrayList();
		
		al.add("puvi");
		al.add(1000);
		al.add(99.60);
		al.add("Arasu");
		al.add(2000);
		al.add(96.50);
		
		
	    List<Object> objAns= tae.filterBytype(al, Integer.class);
	    
	    List<?> typeAns=tae.filterBytype(al, Integer.class);
	    
	    
	    Object o=objAns.get(0);
	    Object i=typeAns.get(0);
	    System.out.println(o);
	    System.out.println(i);
	}

}
