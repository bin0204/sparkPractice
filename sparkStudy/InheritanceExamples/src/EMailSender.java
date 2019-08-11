
public class EMailSender extends MessageSender {
	String senderAddr;
	String emailBody;
	EMailSender(String title, String senderName, String senderAddr, String emailBody) {
		super(title,senderName);
		this.senderAddr = senderAddr;
		this.emailBody = emailBody;
	}
	//슈퍼클래스의 메소드를 오버라이드하는 메소드
	void sendMessage(String recipient) {
		System.out.println("----------------------");
		System.out.println("제목: "+title);
		System.out.println("보내는사람: "+senderName + ""+senderAddr);
		System.out.println("받는사람: "+recipient);
		System.out.println("내용: "+emailBody);
	}
	
}
 
