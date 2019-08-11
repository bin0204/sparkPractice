
public class MethodExample2 {

	public static void main(String[] args) {
//		Account obj = new Account("384029-49394-22", "º¸³ëº¸³ë",300);
		//CheckingAccount Å¬·¡½ºÀÇ »ý¼ºÀÚ È£­ƒ
		CheckingAccount obj = new CheckingAccount("384029-49394-22","º¸³ëº¸³ë",0,"555-333-422234");
		obj.deposit(100342343);
		try {
			int paidAmount = obj.pay("555-333-422234", 450000);
			System.out.println("ÁöºÒ¾×: " + paidAmount);
			System.out.println("ÀÜ¾×: " + obj.balance);
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
