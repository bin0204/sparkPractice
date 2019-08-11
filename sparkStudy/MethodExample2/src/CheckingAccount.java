
public class CheckingAccount extends Account {
	String cardNo; //String Class
	
	//SuperClass로부터 상속받은 필드들을 초기화한다.
	CheckingAccount(String accountNo, String ownerName, int balance, String cardNo){//생성자
		super(accountNo, ownerName, balance); //SuperClass(Account)의 생성자 호출
		this.cardNo = cardNo; // 클래스안에서 선언된 필드를 초기화
	}
	int pay(String cardNo, int amount) throws Exception{
		if(!cardNo.equals(this.cardNo) || (balance < amount)) {
			throw new Exception("Invaild!");
		}
		return withdraw(amount);
	}
}
