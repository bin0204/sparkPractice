
public class MethodOverloadingExample {

	public static void main(String[] args) {
		Physical obj = new Physical("보노보노", 10, 120.0f, 20.0f);
		printPhysical(obj);		
		obj.update(11,120.3f,40.0f);
		printPhysical(obj);
		obj.update(13,180.5f);
		printPhysical(obj);
		obj.update(25);
		printPhysical(obj);
		obj.update("뽀로리",20);
		printPhysical(obj);		
	}
	static void printPhysical(Physical obj) {
		System.out.println("이름: " + obj.name);
		System.out.println("나이: " + obj.age);
		System.out.println("키: " + obj.height);
		System.out.println("몸무게: " + obj.weight);
		System.out.println();
	}
}
