
public class CreditLineAccount extends Account{
	int creditLine; //�ѵ� �ʵ�
	CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}
	
	//withdraw ����� �ٽ� �����ϴ� �޼ҵ� (method overriding)
	int withdraw(int amount) throws Exception {
		if((balance + creditLine) < amount) {
			throw new Exception ("Invaild!");
		}
		balance -= amount;
		return amount;
	}
}
