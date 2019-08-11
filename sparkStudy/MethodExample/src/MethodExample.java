
public class MethodExample {

	public static void main(String[] args) {
		int arr[] = new int[0]; //���̰� 0�� �迭�� ����		
		Numbers obj = new Numbers(arr); //�޼ҵ� ȣ���ϴ� �κп��� ������ �ذ�!!
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
