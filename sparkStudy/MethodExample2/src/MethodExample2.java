
public class MethodExample2 {

	public static void main(String[] args) {
//		Account obj = new Account("384029-49394-22", "보노보노",300);
		//CheckingAccount 클래스의 생성자 호춢
		CheckingAccount obj = new CheckingAccount("384029-49394-22","보노보노",0,"555-333-422234");
		obj.deposit(100342343);
		try {
			int paidAmount = obj.pay("555-333-422234", 450000);
			System.out.println("지불액: " + paidAmount);
			System.out.println("잔액: " + obj.balance);
			System.out.println("Account Number: " + obj.accountNo);
			System.out.println("Owner: " + obj.ownerName);
		}
		catch(Exception e) { //from AccountClass 
			String msg = e.getMessage();
			System.out.println(msg);
		}
		finally {
			System.out.println("Finally block executed!");
		}
	}

}
