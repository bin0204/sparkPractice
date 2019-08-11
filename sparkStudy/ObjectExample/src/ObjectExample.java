public class ObjectExample {

	public static void main(String[] args) {
//		StringBuffer obj; //변수 선언
//		obj = new StringBuffer("Hey, Java"); //객체 생성 
//		//메소드 호출
//		obj.deleteCharAt(1); //delete e
//		obj.deleteCharAt(1); //delete y
//		obj.insert(1, 'i'); 
//		System.out.println(obj); //Hi, Java
//		System.out.println(obj.length());
		
		GoodsStock obj; //변수선언 
		obj = new GoodsStock("Coke","48583",200); //객체 생성
		
		//필드에 값을 대입
//		obj.goodsName = "Coke";
//		obj.goodsCode ="45394";
//		obj.stockNum = 200;
		
		//필드값을 사용
		System.out.println("제품이름:" + obj.goodsName);
		System.out.println("상품코드:" + obj.goodsCode);
		System.out.println("재고수량:" + obj.stockNum);
		

		//메소드 호출
		//obj.addStock(1000);
		obj.substractStock(300); //
		//필드값 사용
		System.out.println("제품이름:" + obj.goodsName);
		System.out.println("상품코드:" + obj.goodsCode);
		System.out.println("상품코드:" + obj.stockNum);
	}
}


