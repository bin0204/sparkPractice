
public class SMSSender extends MessageSender {
	String returnPhoneNo;
	String message;
	SMSSender(String title, String senderName, String returnPhoneNo, String message) {
		super(title, senderName);
		this.returnPhoneNo = returnPhoneNo;
		this.message = message;
	}
	//슈퍼클래스의 메소드를 오버라이드하는 메소드
	void sendMessage(String recipient) {
		System.out.println("------------------------------");
		System.out.println("제목: " + title);
		System.out.println("보내는사람: " + senderName);
		System.out.println("전화번호: " + recipient);
		System.out.println("회신전화번호: " + returnPhoneNo);
		System.out.println("메시지내용: " + message);
	}
}
