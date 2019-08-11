
public class InterfaceExample {

	public static void main(String[] args) throws Exception {
		Lendable arr[] = new Lendable[3];
		arr[0] = new SeparateVolume("34234��","���ǿ�","��������");
		arr[1] = new SeparateVolume("2323","����̼���","���긮ġ");
		arr[2] = new AppCDInfo("2006-2009","Sekai No Owari");
		checkOutAll(arr, "������", "33334234"); //�迭�� �Ķ���ͷ� �Ѱ���
	}
	//static member can be accessed before any objects of its class are created,
	//and without reference to any object.
	static void checkOutAll(Lendable arr[], String borrower, String date) throws Exception {
		for(int i = 0; i < arr.length; i++) {
			arr[i].checkOut(borrower, date); // �迭�� ��� �׸� ���� checkout�޼ҵ� ȣ��
		}
	} 
}
