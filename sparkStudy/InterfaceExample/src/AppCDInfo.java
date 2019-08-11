
public class AppCDInfo extends CDInfo implements Lendable {
	String borrower;
	String checkOutDate;
	byte state;
	
	AppCDInfo(String registerNo, String title) {
		super(registerNo, title);
	}

	@Override
	public void checkOut(String borrower, String date) {
		if(state != 0) { //checkout이 된 상태, 즉 빌릴 수 없다!
			return;
		} 
		this.borrower = borrower;
		this.checkOutDate = date;
		this.state = 1;  //대출이 되니깐 update해줌
		System.out.println("*" + title + " CD가 대출되었습니다.");
		System.out.println("대출인: " + borrower);
		System.out.println("대출일: " + date + "\n");
	}
	@Override
	public void checkIn() {
		this.borrower = null;
		this.checkOutDate = null;
		this.state = 0;
		System.out.println("*"+title+" CD가 반납되었습니다.\n");		
	}

}
