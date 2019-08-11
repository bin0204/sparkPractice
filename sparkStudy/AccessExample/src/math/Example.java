package math;

import java.util.StringTokenizer;

public class Example{

	public static void main(String[] args) {
//		String str = "Hello, Java";
//		System.out.println(str.replace('H', 'A'));
//		System.out.println(str.concat("!!!"));
//		
//		StringTokenizer s = new StringTokenizer("사과 배 복숭아 포도");
//		while (s.hasMoreElements()) {
//			System.out.println(s.nextToken());
		
		String s = "자바 커피";
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			System.out.println(ch);	
		}
		System.out.println("자바 커피 길이 = " + len);
		System.out.println();
		StringTokenizer s1 = new StringTokenizer("사과 배 복숭아 포도");
		while (s1.hasMoreElements()) {
			System.out.println(s1.nextToken());
		}
	}
}

