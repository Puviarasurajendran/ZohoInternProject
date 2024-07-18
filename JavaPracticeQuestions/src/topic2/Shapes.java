package topic2;


abstract class Shapes {

	abstract void area();
	abstract void perimeter();
	
	public void printShape() {
		
		System.out.println("Shape :"+this.getClass().getSimpleName());

	}
	
	
	}

