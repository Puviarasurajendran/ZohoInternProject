package topic2;

public class Main {
	
	public static void main(String[] args) {
		
		Shapes r = new Rectangle(5,4);
		r.printShape();
		r.area();
		r.perimeter();
		
		System.out.println("------------------------------");
		
		Shapes s= new Square(2);
		
		s.printShape();
		s.area();
		s.perimeter();
		
//		PostgreSQLDB pgsDb= new PostgreSQLDB("jdbc:postgresql://localhost:5432/Apimanagement", "adimin", "zoho@1234");
//		pgsDb.getDBConnections();
		
	}

}
