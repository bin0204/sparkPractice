
abstract class MessageSender { //Ŭ���� ��ü�� �߻� Ŭ������ ����
	String title;
	String senderName;
	MessageSender(String title, String senderName) {
		this.title = title;
		this.senderName = senderName;
	}
	//�޼ҵ� ��ü�� ���� �޼ҵ�
	abstract void sendMessage(String recipient); //�߻�޼ҵ� ����
}