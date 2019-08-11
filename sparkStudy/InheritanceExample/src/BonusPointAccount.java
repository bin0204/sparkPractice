
class BonusPointAccount extends Account{
	int bonusPoint;//누적포인트
	BonusPointAccount(String accountNo,String ownerName,int balance,int bonusPoint){
		super(accountNo,ownerName,balance);
		this.bonusPoint=bonusPoint;	
	}
	void deposit(int amount){//예금한다
		super.deposit(amount); //슈퍼클래스의 deposit 메소드 호출
		bonusPoint += (int)(amount*0.001);
	}
}