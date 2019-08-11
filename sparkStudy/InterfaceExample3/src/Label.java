
public class Label implements Changeable {
	String text;
	int w, h;
	String foreground, background;
	String font;
	
	Label(String text, int w, int h, String foreground, String background, String font) {
		this.text = text;
		this.w=w;
		this.h=h;
		this.foreground=foreground;
		this.background=background;
		this.font=font;
	}
	
	@Override
	public void resize(int w, int h) {
		// TODO Auto-generated method stub
		this.w = w;
		this.h = h;
	}
	@Override
	public void setForeground(String color) {
		// TODO Auto-generated method stub
		this.foreground = color;		
	}
	@Override
	public void setBackground(String color) {
		// TODO Auto-generated method stub
		this.background = color;
	}
	@Override
	public void setFont(String font) {
		// TODO Auto-generated method stub
		this.font = font;
	}
	
}
