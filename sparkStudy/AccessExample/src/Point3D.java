
public class Point3D extends Point {
	int z;
	Point3D(int x, int y, int z) {
		super(x,y);
		this.z = z;
	}
	
	//wrong method
	//attempting to assign weaker privileges was protected
//	int getX() {
//		return x;
//	}
//	//wrong method
//	int geyY() {
//		return y;
//	}
	int getZ() {
		return z;
	}
}
