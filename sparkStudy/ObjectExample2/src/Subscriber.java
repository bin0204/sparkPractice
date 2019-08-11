
public class Subscriber {
	String name, id, password;
	String phoneNo, address;
	int age;
	
	Subscriber() {
	}
	
	Subscriber(String name, int age, String id, String password) {
		this.name = name;
		this.age = age; // 여기서의 this는 필드
		this.id = id;
		this.password = password;
	}
	
	Subscriber(String name, int age, String id, String password, String phoneNo, String address) {
		this(name,age,id,password); //여기서의 this는  constructor & reduce duplicates
		this.phoneNo = phoneNo;
		this.address = address;
	}
	
	void changePassword(String password) {
		this.password = password; 
	}
	void changePhoneNo(String phoneNo) {
		this.phoneNo = phoneNo; 
	}
	void setAddress(String address) {
		this.address = address; 
	}
	
}
