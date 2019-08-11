
public class InheritanceExamples {
	
	public static void main(String[] args) {
		EMailSender obj1 = new EMailSender("HappyBirthDay","고객센터","admin@dukeeshop.co.kr","10%할인쿠폰이발행되었습니다.");
		SMSSender obj2 = new SMSSender("HappyBirthDay","고객센터","02-000-0000","10%할인쿠폰이발행되었습니다.");
		//추상메소드 구현하는 메소드를 호출
		
		//서브클래스 객체 obj1, obj2를 가지고 메소드를 호출
		send(obj1,"hatman@yeyeye.com");
		send(obj1,"stickman@yeyeye.com");
		send(obj2, "010-000-0000");
	}
	//슈퍼클래스 타입의 파라미터 변수
	static void send(MessageSender obj, String recipient) {
		obj.sendMessage(recipient);
	}
}
