
public class Account {
	String accountNo;
	String ownerName;
	int balance;
	
	Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	void deposit(int amount) {
		balance += amount;
	}
	int withdraw(int amount) throws Exception { //�� �޼Ұ� �߻��ϴ� �ͼ����� ������ ǥ���ϴ� throws ��
		if(balance < amount) {
			throw new Exception("Balance is not enough!");
		}
		balance -= amount;
		return amount;
	}
}
