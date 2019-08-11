import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class LineNumberExample {

	public static void main(String[] args) {
		LineNumberReader r = null;
		try{
			FileReader fr = new FileReader("C:/Users/seobi/Desktop/poem.txt");
			r = new LineNumberReader(fr);
			while(true){
				//파일로부터 한 라인씩 읽어서 행 번호와 함께 출력한다
				String str = r.readLine();
				if(str==null) { //객체를 초기화 해줘야합니다!!
					break;
				}
				int lineNo = r.getLineNumber();
				out.println(lineNo + ":" + str);
				String s;
				if(str.equalsIgnoreCase("Nam")) {
					out.println("FOUND!");
				}
			}
		}
		catch(FileNotFoundException fnfe){
			out.println("File Not Found.");
		}
		catch(IOException e){
			out.println("File Not Readable.");
		}
		finally{
			try{
				r.close();
			}
			catch(Exception e){
				out.println("Done");
			}
		}
	}
}
