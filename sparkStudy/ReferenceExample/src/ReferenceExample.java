
public class ReferenceExample {
	public static void main(String args[]){
		//�ϳ��� ��ü�� �����ؼ� �ΰ��� ������ ����
		Point obj1 = new Point(10,20);
		Point obj2 = obj1;
		//%d specifies that the single variable is a decimal integer
		//%n specifies that a platform
		System.out.printf("obj1=(%d,%d)%n", obj1.x, obj1.y);
		System.out.printf("obj2=(%d,%d)%n", obj2.x, obj2.y);
		obj2.x=30; // obj2�� x�ʵ忡 30(�ٸ�)���� ����
		System.out.printf("obj1=(%d,%d)%n", obj1.x, obj1.y);
		System.out.printf("obj2=(%d,%d)%n", obj2.x, obj2.y);
		
		Point obj = new Point(10,20);
		System.out.printf("(%d,%d) %n",obj.x,obj.y);
		rearrange(obj);
		System.out.printf("(%d,%d) %n",obj.x,obj.y);
		
		}
	//method
	static void rearrange(Point p) {
		//�Ķ���� ������ �ʵ忡 �ٸ� ���� ����
		p.x = 30;
		p.y = 40;
	}
}
