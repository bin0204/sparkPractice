import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class PrintWriter {

	public static void main(String[] args) {
		System.out.println("***성적표***");
		System.out.printf("%3s:%3d%3d%3d%5.1f%n","김지영",92,87,95,91.3f);
		System.out.printf("%3s:%3d%3d%3d%5.1f%n","박현식",100,90,88,92.7f);
		System.out.printf("%3s:%3d%3d%3d%5.1f%n","최민재",75,88,85,82.7f);
		System.out.printf("작성일자:%1$tY년%1$tm월%1$td일",new GregorianCalendar());
	}

}
