import java.io.*;
import static java.lang.System.out;

public class FileReaderExample {

	public static void main(String[] args) {
		FileReader r = null; //초기화 필요
		try {
			String path = "C:/Users/seobi/Documents/hello.txt";
			r = new FileReader(path); //integer로  값을 읽는다
			while(true) {
				int data = r.read(); 
				if(data == -1) {
					break;
				}
				char c = (char) data;//character로 강제 형변환 필수!!!
				out.print(c);
			}
		} 
		catch (FileNotFoundException e) { //파일자체를 찾지 못할때
			// prints a stack trace for this Throwable object 
			// on the standard error output stream.
			e.printStackTrace();
			out.println("File Not Found!");
		}
		catch (IOException ioe) {//파일은 존재하지만 손상되서 읽지 못할때
			out.println("File is not readable!");
		}
		finally {
			try { //파일을 닫는 명령문을 finally 블록으로 이동
				r.close();
			}
			catch(Exception e) {//close 메소드가 발생하는 익셉션을 처리
				out.println("WRONG!");
			}
		}
	}

}
