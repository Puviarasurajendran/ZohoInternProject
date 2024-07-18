package zohointern;

public class SqurareShapes {
	
	double area;
	double perimeter;
	
	public void areaOfSquare(int side) {
		
		area=side*side;
	}
	
	public void perimeterOfSquare(int side) {
		
		perimeter=4*side;
	}
	
//	public String toString() {
//		return "Area :"+area+"\nperimeter :"+perimeter;	
//		
//	}
	
	public static void main(String[] args) {
		
		SqurareShapes shape= new SqurareShapes();
		shape.areaOfSquare(4);
		shape.perimeterOfSquare(4);
		System.out.println(shape);
		
	}

}
