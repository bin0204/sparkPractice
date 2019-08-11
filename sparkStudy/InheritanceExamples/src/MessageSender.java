
abstract class MessageSender { //클래스 자체도 추상 클래스로 선언
	String title;
	String senderName;
	MessageSender(String title, String senderName) {
		this.title = title;
		this.senderName = senderName;
	}
	//메소드 본체가 없는 메소드
	abstract void sendMessage(String recipient); //추상메소드 선언
}
