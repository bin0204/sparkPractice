
public class Circle {
	 double radius;
	
	Circle(double radius) { //constructor
		this.radius = radius;
	}
	
	double getArea() {
		double area;
		area = 3.14 * radius * radius;
		return area;
	}
}

