package topic2;

public class Square extends Shapes {
	
	private double side;
	
	public Square(double s){
		this.side=s;
	}
	
	@Override
	void area() {
		System.out.println("Area of Square : "+(side*side));
		
	}

	@Override
	void perimeter() {
	
		System.out.println("Perimeter of Square : "+(4*side));
	}

}
