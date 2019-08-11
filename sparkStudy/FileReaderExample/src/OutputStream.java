import java.io.*;
import static java.lang.System.out;

public class OutputStream {

	public static void main(String[] args) {
		FileOutputStream out=null;
		try{
			out=new FileOutputStream("output.dat");
			byte arr[]={0,1,2,3,4,5,6,7,8,9,
			10,11,12,13,14,15,16,17,18,19};
			for(int i = 0; i<arr.length; i++)
				out.write(arr[i]);
		}
		catch(IOException ioe){
			System.out.println("���Ϸ�����Ҽ������ϴ�.");
		}
		finally{
			try{
				out.close();
			}
			catch(Exception e){
			}
		}
	}

}
