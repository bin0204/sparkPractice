import java.util.Scanner;

public class InterfaceExample2 {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter x");
		int x = myObj.nextInt();
		System.out.println("Enter y");
		int y = myObj.nextInt();
		System.out.println("Enter w");
		int w = myObj.nextInt();
		System.out.println("Enter h");
		int h = myObj.nextInt();
		Rectangle obj = new Rectangle(x,y,w,h);
		printRectangle(obj);
		obj.moveTo(25, 35);
		printRectangle(obj);
		obj.moveBy(-5, -5);
		obj.resize(30, 30);
		printRectangle(obj);
	}
	static void printRectangle(Rectangle obj) {
		System.out.printf("사각형:위치(%d,%d)크기(%dx%d)%n",obj.x,obj.y,obj.w,obj.h);
	}
}
