
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
	int withdraw(int amount) throws Exception { //이 메소가 발생하는 익센셥의 종류르 표시하는 throws 절
		if(balance < amount) {
			throw new Exception("Balance is not enough!");
		}
		balance -= amount;
		return amount;
	}
}
