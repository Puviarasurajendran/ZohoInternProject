package lambdapractice;

import java.util.ArrayList;
import java.util.List;

public class lambdaExample1 {

	
	
	public static void main(String[] args) {
		
		List numbers= new ArrayList(List.of(1,2,3,4,4,5,6,7,8,7));
		
		numbers.forEach(n->System.out.println(n));
		
		}
	
}
