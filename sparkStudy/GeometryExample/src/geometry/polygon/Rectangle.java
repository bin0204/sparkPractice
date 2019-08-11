package geometry.polygon;

public class Rectangle {
	public int w, h;
	
	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	public int getArea() {
		return w * h;
	}
}
