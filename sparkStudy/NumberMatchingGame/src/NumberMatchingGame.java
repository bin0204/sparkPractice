import java.lang.Math;
import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class NumberMatchingGame {
	public static void main(String[] args) {
		int count = 0;
		//String str;
		//0 ���� 1������ �Ҽ� ������ 0 ���� 100���� ���� ������ ����� ��
		int num = (int) (Math.random() * 100) + 1;
		while(true) {
			count++;
			//console���� ���δ����� �Է��� ���� 
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
		
		//������ ���!! 
		//String str;
		//int rand =  (int) (Math.random() * 100 + 1);
		//int find = 0;
//		try {
//			java.io.LineNumberInputStream rd = new java.io.LineNumberInputStream(System.in);
//			while(true) {
//				count++;
//				out.println("�Է°�");
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
