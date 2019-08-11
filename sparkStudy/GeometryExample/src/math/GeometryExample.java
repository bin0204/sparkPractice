package math;

import geometry.polygon.*;
import geometry.circle.*;

public class GeometryExample {

	public static void main(String[] args) {
		Circle c = new Circle(2);
		
		//geometry.circle.Circle c = new geometry.circle.Circle(5);
		Rectangle rec = new Rectangle(10,3);
		//geometry.polygon.Rectangle obj = new geometry.polygon.Rectangle(2,3);
		if (c.getArea() > rec.getArea()) {
			System.out.println("Circle area: " + c.getArea() + " > " + "Rectangle area: " + rec.getArea());
		}
		else if (c.getArea() < rec.getArea()) {
			System.out.println("Circle area: " + c.getArea() + " < " + "Rectangle area: " + rec.getArea());
		}
		else {
			System.out.println("Circle area: " + c.getArea() + " = " + "Rectangle area: " + rec.getArea());
		}
	}

}
