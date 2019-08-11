
public class Numbers {
	int num[];
	Numbers(int num[]){
		this.num = num;
	}
	int getTotal(){ //합계를구하는메소드
		int total=0;
		for (int cnt=0; cnt < num.length; cnt++) {
			total += num[cnt];
		}
		return total;
	}
	int getAverage(){ //평균을구하는메소드
		int total;
		total = getTotal();
		int average = total/num.length; //메소드에서 처리되지 못하면 메소를 호출한 쪽으로 던져짐 //메소드가 호출되는 부분
		return average;
	}
}
