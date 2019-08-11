
public class SillyExample {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int a = 3, b = 0;
//		int result;
//		try {
//			result = a / b;
//			System.out.println(result);
//		} 
//		catch (java.lang.ArithmeticException e) {
//			System.out.println("Wrong operation!");
//		} 
//		finally {
//			System.out.println("Done");
//		}
//		
//	}
	
	public static void main(String[] args) {
		int divisor[] = {5,4,3,2,1,0};
		for(int cnt = 0; cnt < 10; cnt++) {
			try {
				int share = 100 / divisor[cnt];
				System.out.println(share);
			}
			catch (java.lang.ArithmeticException e) {
				System.out.println("Wrong operation");
			}
			catch (java.lang.ArrayIndexOutOfBoundsException e) {
				System.out.println("Wrong Index");
			}
		}
		System.out.println("Done");
		
		
		
	}

}
