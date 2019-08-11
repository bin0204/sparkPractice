
public class StaticExample {

	public static void main(String[] args) {
		Accumulator obj1 = new Accumulator();
		Accumulator obj2 = new Accumulator();
		obj1.accumulate(20);
		obj2.accumulate(90);
		int grandTotal = Accumulator.getGrandTotal();
		System.out.println("obj1.total= " + obj1.total);
		System.out.println("obj2.total= " + obj2.total);
		System.out.println("ÃÑ°è= " + Accumulator.grandTotal);
	}

}
