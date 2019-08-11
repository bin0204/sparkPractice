
public class RefTypeExample2 {

	public static void main(String[] args) {
		//가능한 예
		Account obj= new CheckingAccount("111-22-33333333", "홍길동",1000,"5555-6666-7777-8888");
		//obj를 CheckingAccount로 캐스트 할 수 있을 때만 pay메소드 호출
		if(obj instanceof CheckingAccount) {
			pay((CheckingAccount) obj);
		}
		else {
			System.out.println("캐스트 할 수 없는 타입입니다!");
		}
	}
	//method
	static void pay(CheckingAccount obj) {
		try{
			int amount = obj.pay("5555-6666-7777-8888",3000);
				System.out.println("인출액:" + amount);
				System.out.println("카드번호:" + obj.cardNo);
			}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
