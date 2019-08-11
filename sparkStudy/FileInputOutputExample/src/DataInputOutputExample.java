import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class DataInputOutputExample {

	public static void main(String[] args) {
		//DataInputStream in = null;
		ObjectInputStream in = null;
		try {
//			in = new DataInputStream(new FileInputStream("C:/Users/seobi/Desktop/output.dat"));
//			while(true) {
//				//���Ϸκ��� ������ �о ����Ѵ�
//				int data = in.readInt();
//				out.println(data);
			
			in = new ObjectInputStream(new FileInputStream("C:/Users/seobi/Desktop/output.dat"));
			while(true) {
				//���Ϸκ���  GreagorianCalendar��ü�� �о yyyy/mmdd�������� ����Ѵ�
				GregorianCalendar c = (GregorianCalendar)in.readObject();
				int year = c.get(Calendar.YEAR);
				int month=c.get(Calendar.MONTH)+1;
				int date=c.get(Calendar.DATE);
				out.println(year+"/"+month+"/"+date);
			}
		}
		catch (FileNotFoundException fnfe) {
			out.println("File not found");
		}
		//Signals that an end of file or end of stream 
		// has been reached unexpectedly during input.
		catch (EOFException eofe) { 
			out.println("END");
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			out.println("File not readable");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				in.close();
			}
			catch (Exception e) {
				out.println("Done!");
			}
		}
	}

}
