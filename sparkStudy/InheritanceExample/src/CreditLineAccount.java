
public class CreditLineAccount extends Account{
	int creditLine; //한도 필드
	CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}
	
	//withdraw 기능을 다시 구현하는 메소드 (method overriding)
	int withdraw(int amount) throws Exception {
		if((balance + creditLine) < amount) {
			throw new Exception ("Invaild!");
		}
		balance -= amount;
		return amount;
	}
}
