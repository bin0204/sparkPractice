import java.util.*;
import static java.lang.System.*;

public class SystemExample {

	public static void main(String[] args) {
		// > correct printout
		// 2> incorrect printout
		
		//String str = System.getenv("Path");
//		Properties props = System.getProperties();
//		System.out.println(System.out);
		if(args.length != 2) {
			out.println("Usage: java SystemExample <int> <int>");
			exit(1);//명령행 파라미터의 수가 안 맞으면 비정상 종료
		}
		try {
			int num1=Integer.parseInt(args[0]);
			int num2=Integer.parseInt(args[1]);
			int sum=num1+num2;
			out.println("sum="+ sum);
			exit(0);//할 일을 마치고 정상종료
		}
		catch(NumberFormatException e) {
			err.println("Wrong number!");
			exit(-1); // 익셉션이 발생하면 비정상 종료
			//obj = null;  더이상 이 객체가 필요없다.
		}
	}
	static void arrayCopy(char arr1[], char arr2[]) {
		arraycopy(arr1,10,arr2,2,3);
		for(char ch:arr2) {
			System.out.println(ch);
		}
	}
}
