import static java.lang.System.out;

public class SystemExample2 {

	public static void main(String[] args) {
//		char arr1[] =  {'가','나','다','라','마','바','사','아','자','차','카','타','파','하'};
//		char arr2[] = {'a','b','c','d','e','f','g','h','i','j','k'};
//		System.arraycopy(arr1, 5, arr2, 1, 5);
//		for (char c : arr2) {
//			out.println(c);
//		}
		long t1 = System.currentTimeMillis();
		double total = 0.0;
		for (int i=1; i<1000000000; i+=2) {
			if(i / 2 % 2 == 0) {
				total += 1.0 / i;
			}
			else {
				total -= 1.0 / i;
			}
		}
		double pi = total * 4;
		long t2 = System.currentTimeMillis();
		out.println("result = " + pi);
		out.printf("계산에 %d ms가 소요되었습니다!", t2 - t1);
	}

}
