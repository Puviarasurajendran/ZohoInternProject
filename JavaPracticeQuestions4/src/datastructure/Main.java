package datastructure;

public class Main {
	
	
	public static void main(String[] args) {
		
		HashMapImp hm = new HashMapImp();
		
		hm.put("puvi", 25000);
		hm.put("vipu", 35000);
		hm.put("satha", 1000);
		hm.put("Siva", 3000);
		hm.put("parthiban", 4000);
		
		
		System.out.println(hm.get("Siva"));
		System.out.println(hm.containsKey("puvi"));
		System.out.println(hm.containsKey("tamil"));
		
		hm.printtable();
	}

}
