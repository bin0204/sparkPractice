
public class RefTypeExample {

	public static void main(String[] args) {
		Point obj = null;
		if(obj == null){
			System.out.println("obj������ ����Ű�� ��ü�� �����ϴ�");
			return;
		}
		System.out.println("x= " + obj.x);
		System.out.println("y= " + obj.y);
	}
}
