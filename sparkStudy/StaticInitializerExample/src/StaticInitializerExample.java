
public class StaticInitializerExample {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			System.out.println(ThreeArrays.arr1[i] + " + " +ThreeArrays.arr2[i] + " = " + ThreeArrays.arr3[i]);
		}
	}
}
