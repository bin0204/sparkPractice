public class ObjectExample {

	public static void main(String[] args) {
//		StringBuffer obj; //���� ����
//		obj = new StringBuffer("Hey, Java"); //��ü ���� 
//		//�޼ҵ� ȣ��
//		obj.deleteCharAt(1); //delete e
//		obj.deleteCharAt(1); //delete y
//		obj.insert(1, 'i'); 
//		System.out.println(obj); //Hi, Java
//		System.out.println(obj.length());
		
		GoodsStock obj; //�������� 
		obj = new GoodsStock("Coke","48583",200); //��ü ����
		
		//�ʵ忡 ���� ����
//		obj.goodsName = "Coke";
//		obj.goodsCode ="45394";
//		obj.stockNum = 200;
		
		//�ʵ尪�� ���
		System.out.println("��ǰ�̸�:" + obj.goodsName);
		System.out.println("��ǰ�ڵ�:" + obj.goodsCode);
		System.out.println("������:" + obj.stockNum);
		

		//�޼ҵ� ȣ��
		//obj.addStock(1000);
		obj.substractStock(300); //
		//�ʵ尪 ���
		System.out.println("��ǰ�̸�:" + obj.goodsName);
		System.out.println("��ǰ�ڵ�:" + obj.goodsCode);
		System.out.println("��ǰ�ڵ�:" + obj.stockNum);
	}
}


