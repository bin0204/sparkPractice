
public class InheritanceExamples {
	
	public static void main(String[] args) {
		EMailSender obj1 = new EMailSender("HappyBirthDay","������","admin@dukeeshop.co.kr","10%���������̹���Ǿ����ϴ�.");
		SMSSender obj2 = new SMSSender("HappyBirthDay","������","02-000-0000","10%���������̹���Ǿ����ϴ�.");
		//�߻�޼ҵ� �����ϴ� �޼ҵ带 ȣ��
		
		//����Ŭ���� ��ü obj1, obj2�� ������ �޼ҵ带 ȣ��
		send(obj1,"hatman@yeyeye.com");
		send(obj1,"stickman@yeyeye.com");
		send(obj2, "010-000-0000");
	}
	//����Ŭ���� Ÿ���� �Ķ���� ����
	static void send(MessageSender obj, String recipient) {
		obj.sendMessage(recipient);
	}
}
