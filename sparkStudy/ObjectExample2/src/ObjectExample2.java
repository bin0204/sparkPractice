
public class ObjectExample2 {

	public static void main(String[] args) {
//		Subscriber obj1, obj2;
//		obj1 = new Subscriber("연흥부", 10, "poorman","zebi");

		Subscriber obj, obj1, obj2;
		obj = new Subscriber();
		obj1 = new Subscriber("연흥부", 10, "poorman","zebi");
		obj2 = new Subscriber("연농부", 30, "richman","money","054-334-223","마린시티");
		
		obj1.changePassword("test");//메소드 호출
		
		
		printSubscriber(obj);
		printSubscriber(obj1);
		printSubscriber(obj2);
	}
	static void printSubscriber(Subscriber obj) {
		System.out.println("name: " + obj.name);
		if (obj.age <= 0) {
			System.out.println("Are you human being?"); 
		}
		else if (obj.age < 20) {
			System.out.println("Young!"); 
		}
		else {
			System.out.println("Old!");
		}
		System.out.println("age: " + obj.age);
		System.out.println("id: " + obj.id);
		System.out.println("password: " + obj.password);
		System.out.println("phone: " + obj.phoneNo);
		System.out.println("address: " + obj.address);
		System.out.println();
	}

}
