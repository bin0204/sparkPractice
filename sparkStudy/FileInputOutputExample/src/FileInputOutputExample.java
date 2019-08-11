import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class FileInputOutputExample {

	public static void main(String[] args) {
		//DataOutputStream o = null;
		ObjectOutputStream ou = null;
		try {
//			o = new DataOutputStream(new FileOutputStream("C:/Users/seobi/Desktop/output.dat"));
//			int arr[] = {0,1,2,3,4,5,6,7,8,9};
//			for (int i = 0; i < arr.length; i++) {
//				o.writeInt(arr[i]);
			
			//파일을 엽니다
			ou = new ObjectOutputStream(new FileOutputStream("C:/Users/seobi/Desktop/output.dat"));
			//GregorianCalendar 객체를  생성해서 파일에 씁니다!
			ou.writeObject(new GregorianCalendar(2019, 0, 1));
			ou.writeObject(new GregorianCalendar(2019, 0, 2));
			ou.writeObject(new GregorianCalendar(2019, 0, 3));
			}
		catch(IOException ioe) {
			out.println("파일을 출력할수없습니다");
		}
		finally {
			try {
				//o.close();
				ou.close();
			}
			catch (Exception e) {
				out.println("DONE!");
			}
		}
	}

}
