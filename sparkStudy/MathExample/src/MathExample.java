import static java.lang.System.out;
import java.util.*;

public class MathExample {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			//0 ���� 1������ �Ҽ� ������ 0 ���� 9���� ���� ������ ����� ��
			int num = (int) (Math.random() * 10); 
			out.println(num);
		}
		out.println("-------------------");
		
		//Random Ŭ������ �̿��Ͽ� ������ �߻��ϴ� ���α׷�
		Random r = new Random();
		Random rd = new Random(349239L);
		out.println(r.nextInt(100)); //100���� ���� �μ� ��
		out.println(rd.nextInt(100));
	}
}
