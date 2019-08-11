
public class ReferenceExample {
	public static void main(String args[]){
		//하나의 객체를 생성해서 두개의 변수에 대입
		Point obj1 = new Point(10,20);
		Point obj2 = obj1;
		//%d specifies that the single variable is a decimal integer
		//%n specifies that a platform
		System.out.printf("obj1=(%d,%d)%n", obj1.x, obj1.y);
		System.out.printf("obj2=(%d,%d)%n", obj2.x, obj2.y);
		obj2.x=30; // obj2의 x필드에 30(다른)값을 대입
		System.out.printf("obj1=(%d,%d)%n", obj1.x, obj1.y);
		System.out.printf("obj2=(%d,%d)%n", obj2.x, obj2.y);
		
		Point obj = new Point(10,20);
		System.out.printf("(%d,%d) %n",obj.x,obj.y);
		rearrange(obj);
		System.out.printf("(%d,%d) %n",obj.x,obj.y);
		
		}
	//method
	static void rearrange(Point p) {
		//파라미터 변수의 필드에 다른 값을 대입
		p.x = 30;
		p.y = 40;
	}
}
