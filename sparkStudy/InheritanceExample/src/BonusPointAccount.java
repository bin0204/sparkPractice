
class BonusPointAccount extends Account{
	int bonusPoint;//��������Ʈ
	BonusPointAccount(String accountNo,String ownerName,int balance,int bonusPoint){
		super(accountNo,ownerName,balance);
		this.bonusPoint=bonusPoint;	
	}
	void deposit(int amount){//�����Ѵ�
		super.deposit(amount); //����Ŭ������ deposit �޼ҵ� ȣ��
		bonusPoint += (int)(amount*0.001);
	}
}