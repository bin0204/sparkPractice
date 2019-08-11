
public class Physical {
	String name;
	int age;
	float height, weight;
	Physical(String name, int age, float height, float weight) {
		this.name =name;
		this.age= age;
		this.height = height;
		this.weight = weight;
	}
	void update(int age) {
		this.age = age;
	}
	void update(String name, int age) {
		this.name = name;
		this.age = age;
	}
	void update(int age, float height) {
		this.age = age;
		this.height = height;
	}
	void update(int age, float height, float weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
}
