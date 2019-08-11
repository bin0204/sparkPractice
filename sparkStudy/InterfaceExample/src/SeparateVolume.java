
public class SeparateVolume implements Lendable {
	String requestNo;
	String bookTitle;
	String writer;
	String borrower;
	String checkOutDate;
	byte state; //대출 상태
	
	//Constructor
	SeparateVolume(String requestNo, String bookTitle, String writer) {
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	//대출한다
	@Override
	public void checkOut(String borrower, String date) throws Exception {
		if(state != STATE_NORMAL) {  //checkout이 된 상태, 즉 빌릴 수 없다!
			throw new Exception("*대출불가: " + bookTitle);
		}
		//대출할때!!
		this.borrower = borrower;
		this.checkOutDate = date; 
		this.state = STATE_BORROWED; //대출이 되니깐 update해줌
		System.out.println("*" + bookTitle + " 이(가)대출되었습니다.");
		System.out.println("대출인: " + borrower);
		System.out.println("대출일: " + date + "\n");
	} 
	//반납한다
	@Override
	public void checkIn() {
		this.borrower = null;
		this.checkOutDate = null;
		this.state = 0;
		System.out.println("*" + bookTitle + " 이(가) 반납되었습니다.");
	}
	
}
