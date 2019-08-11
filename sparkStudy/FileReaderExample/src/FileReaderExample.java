import java.io.*;
import static java.lang.System.out;

public class FileReaderExample {

	public static void main(String[] args) {
		FileReader r = null; //�ʱ�ȭ �ʿ�
		try {
			String path = "C:/Users/seobi/Documents/hello.txt";
			r = new FileReader(path); //integer��  ���� �д´�
			while(true) {
				int data = r.read(); 
				if(data == -1) {
					break;
				}
				char c = (char) data;//character�� ���� ����ȯ �ʼ�!!!
				out.print(c);
			}
		} 
		catch (FileNotFoundException e) { //������ü�� ã�� ���Ҷ�
			// prints a stack trace for this Throwable object 
			// on the standard error output stream.
			e.printStackTrace();
			out.println("File Not Found!");
		}
		catch (IOException ioe) {//������ ���������� �ջ�Ǽ� ���� ���Ҷ�
			out.println("File is not readable!");
		}
		finally {
			try { //������ �ݴ� ��ɹ��� finally ������� �̵�
				r.close();
			}
			catch(Exception e) {//close �޼ҵ尡 �߻��ϴ� �ͼ����� ó��
				out.println("WRONG!");
			}
		}
	}

}
