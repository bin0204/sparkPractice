//interface는 기능만 있고, 필드는 없다
interface Lendable {
	final static byte STATE_BORROWED = 1; //대출중
	final static byte STATE_NORMAL = 0;
	
	//abstract 안써도 된다!
	void checkOut(String borrower, String date) throws Exception; 
	void checkIn();
}
