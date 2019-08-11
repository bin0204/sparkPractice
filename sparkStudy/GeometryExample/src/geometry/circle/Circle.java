package geometry.circle;

public class Circle {
	public int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	public double getArea() {
		return radius * radius * Math.PI;
	}
}