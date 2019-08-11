package com.java;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class Main2 {

	public static void main(String[] args) {
		//DB접속
		Connection conn = DBConn.connectOralce();
		
		//SELECT
	 	DBSelect select = new DBSelect();
	 	Map<String, Object> map = new HashMap<String, Object>();
	 	
	 	map.put("ID", "a");
	 	map.put("PW", "a");
	 	map.put("NO", "5");
	 	Map<String, Object> recvMap = select.selectShopMemberOne(conn, map);
	 	Map<String, Object> recvMap1 = select.selectShopItemOne(conn, map);
	 	
	 	if(recvMap != null ) {
	 		System.out.println(recvMap.get("ID"));
	 		System.out.println(recvMap.get("NAME"));
	 		System.out.println(recvMap.get("EMAIL"));
	 	}
	 	System.out.println("*******************************");
	 	/*
	 	 * SHOP_ITEM 테이블에서 물품번호가 5번인 물품명과 가격, 재고 수량을 출력
	 	 */
	 	if (recvMap1 != null) {
	 		System.out.println("ITEM_ID: "+ recvMap1.get("NO"));
	 		System.out.println("ITEM_NAME: "+recvMap1.get("NAME"));
	 		System.out.println("ITEM_PRICE: "+recvMap1.get("PRICE"));
	 		System.out.println("ITEM_QTY: "+recvMap1.get("QTY"));	
	 	}
	 	else {
	 		System.out.println("SOMETHING GOES WRONG!!!");
	 	}
	}

}
