
public class CheckingAccount extends Account {
	String cardNo; //String Class
	
	//SuperClass�κ��� ��ӹ��� �ʵ���� �ʱ�ȭ�Ѵ�.
	CheckingAccount(String accountNo, String ownerName, int balance, String cardNo){//������
		super(accountNo, ownerName, balance); //SuperClass(Account)�� ������ ȣ��
		this.cardNo = cardNo; // Ŭ�����ȿ��� ����� �ʵ带 �ʱ�ȭ
	}
	int pay(String cardNo, int amount) throws Exception{
		if(!cardNo.equals(this.cardNo) || (balance < amount)) {
			throw new Exception("Invaild!");
		}
		return withdraw(amount);
	}
}
