import java.io.*;
import static java.lang.System.out;

public class FileDumpByte {

	public static void main(String[] args) {
		if(args.length < 1) {
			out.println("Usage: java FileDump <filename>");
			return;
		}
		FileInputStream in = null;
		try {
			in = new FileInputStream(args[0]);
			byte arr [] = new byte[16]; //16바이트 씩
			while(true) {
				int num = in.read(arr);
				if(num < 0) {
					break;
				}
				for(int i = 0; i < num; i++) {
					out.printf("%02X",arr[i]);
				}
				out.println();
			}
		}
		catch (FileNotFoundException fe) {
			out.println(args[0] + "File not Found!");
		}
		catch(IOException e){
			System.out.println(args[0]+"File not readable");
		}
		finally {
			try {
				in.close();
			}
			catch (Exception e) {
				out.println("Done");
			}
		}
	}

}
