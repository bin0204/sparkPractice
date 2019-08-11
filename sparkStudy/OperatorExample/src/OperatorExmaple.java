
public class OperatorExmaple {

	public static void main(String[] args) {
//		short num1 = 100;
//		short num2 = (short) -num1;
//		System.out.println(num2);
//		String str1 = "num = " + 3 + 4; //문자열 먼저와서 concatenation 으로 인식
//		String str2 = 3 + 4 + " = num"; //연산으로 먼저 인식 후 문자열 concatenation
//		System.out.println(str1); 
//		System.out.println(str2);
//		char ch = 'A';
//		System.out.println(ch);
//		int num = ch;
//		System.out.println(num);
//		int num1 = 0 , num2 = 0, num3 = 0, num4 = 0;
//		int result1 = num1++; //num1 의 기존값 0
//		int result2 = num2--; //0
//		int result3 = ++num3; //num3의 새로운 값 1
//		int result4 = --num4; //-1
//		int result1 = num1++; // 0
//		int result2 = num1--; //1
//		int result3 = ++num1; //1
//		int result4 = --num1; //0
//		System.out.println("result1 = " + result1);
//		System.out.println("result2 = " + result2);
//		System.out.println("result3 = " + result3);
//		System.out.println("result4 = " + result4);
		
		//부동소수점을 가지고 비교연삱다를 쓰면 오류이다
		//"같음"이 나와야하지만  run을 하면 "다름"이 나옴!!
		//쓰지마세용
//		double num1 = 1.1 + 2.2;
//		double num2 = 3.3;
//		if (num1 == num2) {
//			System.out.println("같음");
//		}
//		else {
//			System.out.println("다름"); 
//		}
//		int a = 20, b = 30, max;
//		max = a < b ? a:b;
//		System.out.println(max);
//		int num = 29;
//		num -= 2 + 3 * 4; //29 - 14
//		System.out.println(num);
//		short num1 = (short)300;//int 타입 상수 300을 short타입으로 변환
//		byte num2 = (byte) 300; //int 타입 상수 300을 byte 타입으로 변환
//		//output = 44 because byte range is from -128 to 127
//		int num3 = (int) 12.9; //double 타입 상수 12.9 를 int 타입으로 변환
//		System.out.println(num1);
//		System.out.println(num2);
//		System.out.println(num3);
		
		int a = 2, b = 3, c = 5;
		double d = 4.0, e = 0.5, f;
		f = ((a+b) == c ) ? d:e; //true 일때 4.0 false 일때 0.5
		System.out.println(f);
		
	}
}
