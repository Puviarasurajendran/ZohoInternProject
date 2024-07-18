package topic2;


public class Rectangle extends Shapes {

	private double length;
	private double breadth;

	public Rectangle(double l,double b) {
		this.length=l;
		this.breadth=b;
		
	}
	
	@Override
	void area() {
       
		System.out.println("Area of Rectangle : "+(length*breadth));
	}

	@Override
	void perimeter() {
		System.out.println("Perimeter of Rectangle : "+(2*(length+breadth)));
	}

}
