import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class FileExample {

	public static void main(String[] args) {
		File f = new File("."); 
		File arr[] = f.listFiles(); //list files
		for(int i = 0; i < arr.length; i++) {
			String name = arr[i].getName();
			if(arr[i].isFile()==true) { //true 생략가능
				out.printf("%-25s %2d",name,arr[i].length());
			}
			else {
				out.printf("%-25s<DIR>",name);
			}
			long time = arr[i].lastModified();
			GregorianCalendar c = new GregorianCalendar();
			c.setTimeInMillis(time);
			out.printf("%1$tF %1$tT %n",c);
		}
	}

}
