import java.io.*;
import static java.lang.System.out;

public class FileWriterExample {

	public static void main(String[] args) {
		FileWriter w = null;
		try {
			w = new FileWriter("C:/Users/seobi/Documents/helloOutput.txt");
			char arr[] = {'H','e','o','l','l',' ','P','H','P'};
			String arr1[] = {"Hello World!","Hello Swift!","Hello JavaScript!"};
			for(int i = 0; i < arr1.length; i++) {
				w.write(arr1[i]);
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			out.println("NO OUTPUT");
		}
		finally {
			try {
				w.close();
			}
			catch(Exception e) {
				out.println("DONE!");
			}
		}
	}

}
