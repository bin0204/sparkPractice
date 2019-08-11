
public class MethodExample {

	public static void main(String[] args) {
		int arr[] = new int[0]; //길이가 0인 배열을 생성		
		Numbers obj = new Numbers(arr); //메소드 호출하는 부분에서 문제를 해결!!
		try {
			int avg = obj.getAverage();
			System.out.println("average : " + avg);
		}
		catch(java.lang.ArithmeticException e) { //handle the zero array error exception
			System.out.println("WARNING!!!!!");
			System.out.println("Are you trying to get an average of zero length array?");
		}
		finally {
            System.out.println("finally block executed"); 
		}
	}
}
