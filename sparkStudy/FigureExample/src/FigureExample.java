
public class FigureExample {

	public static void main(String[] args) {
		Circle obj1 = new Circle(0.0);
		Square obj2 = new Square(0.0,0.0);
		obj1.radius = 5.0;
		obj2.row = 2.0;
		obj2.column = 4.0;
		double area1 = obj1.getArea();
		double area2 = obj2.getArea();
		System.out.println("Circle radius: " + obj1.radius);
		System.out.println("Circle area: "+ area1);
		System.out.println("Square row: "+ obj2.row + " Square column: " + obj2.column);
		System.out.println("Square area: "+ area2);
	}

}
