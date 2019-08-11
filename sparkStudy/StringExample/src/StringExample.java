import static java.lang.System.out;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class StringExample {

	public static void main(String[] args) {
		//to replace from system.out to "out"
		//PrintStream out = System.out;
		
		String s1 = "�ڹ�";
		String s2 = "�ڹ�";
		
		boolean check;
		//check = s1.endsWith("��");
		check = s1.endsWith("��");
		out.println("return: " + check);
		
		if(s1.equals(s2)) {
			out.println("same");
		}
		else {
			out.println("different");
		}
		
		String s3 = new String("�ڹ�");
		String s4 = new String("�ڹ�");
		if(s3.equals(s4)) {
			out.println("same");
		}
		else {
			out.println("different");
		}
		
		String s = "United States";
		out.println(s.substring(5, 10));
		 
		String str1 = " Happy Birthday ";
		String str2 = str1.trim();
		
		out.println(str2);
	    out.println(str2.concat(" to you!"));
	    out.println(str2.toUpperCase());
		out.println(str2.toLowerCase());
		out.println(str2.replace('y','i'));
		out.println(str1);
		out.println(str2);
		
		StringBuilder sb = new StringBuilder("abcdefghi");
		printStringBuilder(sb);
		sb.append("jklmnopqrstu");
		printStringBuilder(sb);
		sb.insert(10, "dddddddd");
		printStringBuilder(sb);
//		out.println(sb);
//		out.println(sb.append("jklmnopqrstu"));
//		out.println(sb.insert(20, "vwxyz")); //u �ڸ��� ���ڿ��ֱ�
//		out.println(sb.delete(23, 26));//y,z,u �����(
//		out.println(sb.deleteCharAt(9)); //j �����
		
		StringBuilder sb2 = new StringBuilder(100);
		sb2.append("java");
		out.println(sb2 + ": " + sb2.capacity());
		sb2.trimToSize(); //������ ���� ũ�⸦ �����ϰ� ���̴� �޼ҵ�
		out.println(sb2 + ": " + sb2.capacity());
		
		//StringTokenizer Ŭ����
		StringTokenizer st = new StringTokenizer("���=10|��=2|������=1|����=9","=|",true);
		while (st.hasMoreElements()) {
			String token = st.nextToken();
			if(token.equals("=")) {
				out.print("\t"); //a tab
			}
			else if(token.equals("|")) {
				out.print("\n"); //new line
			}
			else {
				out.print(token);
			}
		}
	}
	static void printStringBuilder(StringBuilder sb) {
		String str = sb.toString();
		int len = sb.length();
		int bufSize = sb.capacity();
		out.printf("%s(%d): %d %n", str, len, bufSize);
	}
}
