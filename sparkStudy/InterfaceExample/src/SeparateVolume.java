
public class SeparateVolume implements Lendable {
	String requestNo;
	String bookTitle;
	String writer;
	String borrower;
	String checkOutDate;
	byte state; //���� ����
	
	//Constructor
	SeparateVolume(String requestNo, String bookTitle, String writer) {
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	//�����Ѵ�
	@Override
	public void checkOut(String borrower, String date) throws Exception {
		if(state != STATE_NORMAL) {  //checkout�� �� ����, �� ���� �� ����!
			throw new Exception("*����Ұ�: " + bookTitle);
		}
		//�����Ҷ�!!
		this.borrower = borrower;
		this.checkOutDate = date; 
		this.state = STATE_BORROWED; //������ �Ǵϱ� update����
		System.out.println("*" + bookTitle + " ��(��)����Ǿ����ϴ�.");
		System.out.println("������: " + borrower);
		System.out.println("������: " + date + "\n");
	} 
	//�ݳ��Ѵ�
	@Override
	public void checkIn() {
		this.borrower = null;
		this.checkOutDate = null;
		this.state = 0;
		System.out.println("*" + bookTitle + " ��(��) �ݳ��Ǿ����ϴ�.");
	}
	
}
