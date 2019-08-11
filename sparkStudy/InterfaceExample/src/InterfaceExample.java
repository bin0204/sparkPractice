
public class InterfaceExample {

	public static void main(String[] args) throws Exception {
		Lendable arr[] = new Lendable[3];
		arr[0] = new SeparateVolume("34234개","파피용","베르베르");
		arr[1] = new SeparateVolume("2323","서양미술사","곰브리치");
		arr[2] = new AppCDInfo("2006-2009","Sekai No Owari");
		checkOutAll(arr, "남서빈", "33334234"); //배열을 파라미터로 넘겨줌
	}
	//static member can be accessed before any objects of its class are created,
	//and without reference to any object.
	static void checkOutAll(Lendable arr[], String borrower, String date) throws Exception {
		for(int i = 0; i < arr.length; i++) {
			arr[i].checkOut(borrower, date); // 배열의 모든 항목에 대해 checkout메소드 호출
		}
	} 
}
