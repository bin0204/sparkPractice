import java.lang.Math;
import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class NumberMatchingGame {
	public static void main(String[] args) {
		int count = 0;
		//String str;
		//0 부터 1까지의 소수 난수를 0 부터 100까지 정수 난수로 만드는 식
		int num = (int) (Math.random() * 100) + 1;
		while(true) {
			count++;
			//console에서 라인단위로 입력을 받음 
			Scanner input = new Scanner(in); //System.in
			out.println("Enter your number");
			int userNum = input.nextInt();
			if (userNum > num) {
				out.println("Your number is bigger than computer");
				out.println("ComputerNumber :" + num);
			}
			else if (userNum < num) {
				out.println("Your number is smller than computer");
				out.println("ComputerNumber :" + num);
			}
			else {
				out.println("You got the correct number at " + count + " times!");
				exit(0);
				//break;
			}
		}
		
		//교수님 방법!! 
		//String str;
		//int rand =  (int) (Math.random() * 100 + 1);
		//int find = 0;
//		try {
//			java.io.LineNumberInputStream rd = new java.io.LineNumberInputStream(System.in);
//			while(true) {
//				count++;
//				out.println("입력값");
//				str = rd.readLine();
//				find = Integer.parseInt(str);
//				if(find == rand) {
//					out.println("");
//					break;
//				}
//				else if(find > rand) {
//					out.println("");
//				}
//				else {
//					out.println("");
//				}
//			}
//		}
//		catch (Exception e) {
//			
//		}
	}
}
