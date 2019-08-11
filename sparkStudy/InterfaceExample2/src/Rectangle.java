
public class Rectangle implements Transformable{
	int x, y, w, h;
	Rectangle(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	//Movable 인터페이스
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//Movable 인터페이스
	@Override
	public void moveBy(int xOffset, int yOffset) {
		this.x += xOffset;
		this.y += yOffset;
	}
	//Transformable 인터페이스
	@Override
	public void resize(int w, int h) {
		this.w = w;
		this.h = h;
	}

}
