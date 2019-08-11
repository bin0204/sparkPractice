import static java.lang.System.*; 
import java.util.*;

public class PracticeExample {

	public static void main(String[] args) {
		Scanner input = new Scanner(in);
		int score;
		int count = 0;
		int totalScore = 0;
		double avg;
		
		out.println("Enter the score (-1 or quit)");
		score = input.nextInt();
		while((score >= 1) && (score <= 10)) {
			totalScore += score;
			count++;
			out.println("Enter the score (-1 or quit)");
			score = input.nextInt();
		}
		if((input.equals("quit")) || (input.equals(-1)) ) {
			exit(0);
		}
		avg = (double) totalScore / count;
		out.println("The average of your score: " + avg);
		//out.printl("Enter the score (-1 or quit");
		
//		int sum = 0;
//		int count = 0;
//		String str1 = "-1";
//		String str2 = "quit";
//		while(true) {
//			Scanner input = new Scanner(in);
//			out.println("Enter your number between 1 to 10");
//			// -1 혹은 quit 문자열이 입력되면 프로그램을 종료한다
//			if ((input.equals(str1)) || (input.equals(str2))) {
//				exit(0);
//			}
//			else {
//				while(input.hasNext()) {
//					out.println("Enter your number between 1 to 10");
//					int num = input.nextInt();
//					sum += num;
//					count++;
//			    }
//		
//			}
//			out.println(sum);
//		}	
	}
}
