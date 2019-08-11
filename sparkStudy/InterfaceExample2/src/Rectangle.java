
public class Rectangle implements Transformable{
	int x, y, w, h;
	Rectangle(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	//Movable �������̽�
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//Movable �������̽�
	@Override
	public void moveBy(int xOffset, int yOffset) {
		this.x += xOffset;
		this.y += yOffset;
	}
	//Transformable �������̽�
	@Override
	public void resize(int w, int h) {
		this.w = w;
		this.h = h;
	}

}
