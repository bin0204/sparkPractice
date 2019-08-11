
public class RefTypeExample {

	public static void main(String[] args) {
		Point obj = null;
		if(obj == null){
			System.out.println("obj변수가 가리키는 객체가 없습니다");
			return;
		}
		System.out.println("x= " + obj.x);
		System.out.println("y= " + obj.y);
	}
}
