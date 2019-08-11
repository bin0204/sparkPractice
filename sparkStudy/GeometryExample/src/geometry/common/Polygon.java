package geometry.common;
public class Polygon {
	protected int x[];
	protected int y[];
	protected Polygon(int vertexNum) {
		x = new int[vertexNum];
		y = new int[vertexNum];
	}
	protected void setPoint(int i, int x, int y) {
		this.x[i] = x;
		this.y[i] = y;
	}
}
