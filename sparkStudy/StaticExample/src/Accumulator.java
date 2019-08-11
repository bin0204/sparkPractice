
public class Accumulator {
	int total = 0;
	static int grandTotal = 0; //정적 필드 - memory를 공유!! , 초기화가 한번만 된다
	void accumulate(int amount) {
		total += amount;
		grandTotal += amount;
	}
	static int getGrandTotal() { //정적메소드 선언
		return grandTotal;
	}
}
