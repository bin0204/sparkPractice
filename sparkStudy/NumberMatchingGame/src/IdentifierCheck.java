import java.util.*;
import static java.lang.System.*;
import java.lang.Character;

class IdentifierCheck {

	public static void main(String[] args) {
		//신분증 첫 원소는 문자, '$' , '_' 만 사용가능
		//다른 원소는 문자 및,숫자, '$' , '_' 만 사용가능
		//Character.isLetter(ch), Character.isLetterOrDigit(ch) 사용
		
		String line;
		char ch;
		
		out.println("Let's check your ID! ");
		out.println("Do you have nice one?");
		
		Scanner input = new Scanner(in);
		boolean legal = true;
		
		line = input.nextLine();
		ch = line.charAt(0);
		
		if(!(Character.isLetter(ch) || ch == '$' || ch == '_')) {
			legal = false;
		}
		for(int i = 1; i < line.length() && legal; i++) {
			ch = line.charAt(i);
			if(!(Character.isLetter(ch) || ch == '$' || ch == '_')) {
				legal = false;
			}
		}
		if(legal) {
			out.println("");
		}
		else {
			out.println("");
		}
		
		
//		if(arr.length < 12) {
//			out.println("You put invailded ID");
//		}
//		else if (arr[0].isLetter)
//		
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = input.next();
//			out.println(arr[i]);
//		}
//		out.println(arr[0]);
//		
		
//		if (id.length() == 12) {
//			if(C)
//		}
//		else { // over or less than 12 lengths of ID
//			out.println("Did you write correct your ID?");
//		}
	}

	private static Character Character() {
		// TODO Auto-generated method stub
		return null;
	}

}
