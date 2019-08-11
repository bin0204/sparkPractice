import java.lang.Math;

import static java.lang.System.in;
import static java.lang.System.out;
import java.util.*;

public class SquarePractice {

	public static void main(String[] args) {
		Scanner input = new Scanner(in); 
		double w;
		double h;
		out.println("Enter your w");
		w = input.nextDouble();//½Ç¼ö°ª
		out.println("Enter your h");
		h = input.nextDouble();
		//hypotenuse = ºøº¯ 
		// sqrt(a2 + b2)
		double c = Math.sqrt(w*w + h*h);
		out.println(Math.pow(w,2));
		out.println(Math.pow(h,2));
		out.println("Hypotenuse = " + c);
	
	}

}
