package streampackage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
	
	
	
	
	public static void main(String[] args) {
		
		List<String> names= new ArrayList(List.of("Puvi","Raja","Vinayag","Parthiban","Theeran"));	
		
		List<Integer> numbers= new ArrayList(List.of(2,5,2,6,1,8,5));
		
		Stream<String> filterName=names.stream().filter(n->n.startsWith("P"));
		
		Stream square= numbers.stream().map(x->x*x);
		
		square.sorted().forEach(e->System.out.println(e));
		
//		square.sorted().forEach(e->System.out.println(e));
		
		numbers.stream().distinct().collect(Collectors.toList()).forEach(n->System.out.print(n+" "));
		
		int sum = numbers.stream().reduce(0, (c,e)->c+e);
		
		System.out.println("sum :"+sum);
		
		
	}

}
