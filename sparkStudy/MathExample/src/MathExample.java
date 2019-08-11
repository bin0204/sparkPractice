import static java.lang.System.out;
import java.util.*;

public class MathExample {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			//0 부터 1까지의 소수 난수를 0 부터 9까지 정수 난수로 만드는 식
			int num = (int) (Math.random() * 10); 
			out.println(num);
		}
		out.println("-------------------");
		
		//Random 클래스를 이용하여 난수를 발생하는 프로그램
		Random r = new Random();
		Random rd = new Random(349239L);
		out.println(r.nextInt(100)); //100보다 작은 인수 값
		out.println(rd.nextInt(100));
	}
}
