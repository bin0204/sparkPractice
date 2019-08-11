
public class ThreeArrays {
	static int arr1[];
	static{ //정적 초기화 블럭
		arr1 = new int[10];
		for(int cnt=0; cnt<10; cnt++) {
			arr1[cnt] = cnt + 1;
		}
	}
	static int arr2[];
	static{  //정적 초기화 블럭
		arr2 = new int[10];
		for(int cnt=0; cnt<10; cnt++) {
			arr2[cnt] = (cnt+1) * 10000;
		}
	}
	static int arr3[];
	static{ //정적 초기화 블럭
	arr3 = new int[10];
		for(int cnt=0; cnt<10; cnt++) {
			arr3[cnt] = arr1[cnt] + arr2[cnt];
		}
	}
}
