
public class Accumulator {
	int total = 0;
	static int grandTotal = 0; //���� �ʵ� - memory�� ����!! , �ʱ�ȭ�� �ѹ��� �ȴ�
	void accumulate(int amount) {
		total += amount;
		grandTotal += amount;
	}
	static int getGrandTotal() { //�����޼ҵ� ����
		return grandTotal;
	}
}
