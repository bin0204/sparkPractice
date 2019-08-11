
public class Square {
	double row;
	double column;
	
	Square(double row, double column) {
		this.row = row;
		this.column = column;
		
	}
	double getArea() {
		double area;
		area = row * column;
		return area;
	}
	
}
