//interface�� ��ɸ� �ְ�, �ʵ�� ����
interface Lendable {
	final static byte STATE_BORROWED = 1; //������
	final static byte STATE_NORMAL = 0;
	
	//abstract �Ƚᵵ �ȴ�!
	void checkOut(String borrower, String date) throws Exception; 
	void checkIn();
}
