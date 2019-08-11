public class GoodsStock {
	//필드 선언
	String goodsName;
	String goodsCode;
	int stockNum;
	
	//생성자 (constructor) 
	GoodsStock(String name, String code, int num) {
		goodsName = name;
		goodsCode = code;
		stockNum = num;
	}
	
	void addGoods(int goods) {
		goodsName += goods;
	}
	void addStock(int amount) {
		stockNum += amount;
	}

	int substractStock(int amount) {
		if (stockNum < amount) {
			System.out.println("Dude, I only have "+stockNum+" stocks..");
			return 0;
		}
		stockNum -= amount;
		return stockNum;	
		}
}

