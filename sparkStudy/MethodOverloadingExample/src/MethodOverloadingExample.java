
public class MethodOverloadingExample {

	public static void main(String[] args) {
		Physical obj = new Physical("���뺸��", 10, 120.0f, 20.0f);
		printPhysical(obj);		
		obj.update(11,120.3f,40.0f);
		printPhysical(obj);
		obj.update(13,180.5f);
		printPhysical(obj);
		obj.update(25);
		printPhysical(obj);
		obj.update("�Ƿθ�",20);
		printPhysical(obj);		
	}
	static void printPhysical(Physical obj) {
		System.out.println("�̸�: " + obj.name);
		System.out.println("����: " + obj.age);
		System.out.println("Ű: " + obj.height);
		System.out.println("������: " + obj.weight);
		System.out.println();
	}
}
