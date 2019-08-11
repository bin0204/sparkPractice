package com.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class DBSelect {


	public Map<String, Object> selectShopMemberOne(Connection conn, Map<String, Object> map) {
		
		try {
			String sql = "SELECT * FROM SHOP_MEMBER WHERE MEM_ID=? AND MEM_PW=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, (String) map.get("ID"));
			ps.setString(2, (String) map.get("PW"));
			
			//int ret = ps.executeUpdate() insert, update, delete일때 사용하는 것 (숫자 반환)
			ResultSet rs = ps.executeQuery(); //SELECT
			while(rs.next()) {//데이터가 있다면
				//map을 해야한다 main에 보내주기 위해서 
				Map<String, Object> retMap = new HashMap<String, Object>();
				retMap.put("ID", rs.getString("MEM_ID"));
				retMap.put("NAME", rs.getString("MEM_NAME"));
				retMap.put("EMAIL", rs.getString("MEM_EMAIL"));
				ps.close();
				return retMap;
			}
			ps.close(); //cursor exceed ... 오류발생하기에 꼭 닫아줘야한다
			return null;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	//SHOP ITEM 가져오는 METHOD
	
	public Map<String, Object> selectShopItemOne(Connection conn, Map<String, Object> map) {
		try {
			String sql = "SELECT * FROM SHOP_ITEM WHERE ITM_NO=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, (String) map.get("NO"));
			
			//int ret = ps.executeUpdate() insert, update, delete일때 사용하는 것 (숫자 반환)
			ResultSet rs = ps.executeQuery(); //SELECT
			while(rs.next()) {//데이터가 있다면
				//map을 해야한다 main에 보내주기 위해서 
				Map<String, Object> retMap = new HashMap<String, Object>();
				retMap.put("NO", rs.getString("ITM_NO"));
				retMap.put("NAME", rs.getString("ITM_NAME"));
				retMap.put("PRICE", rs.getInt("ITM_PRICE"));
				retMap.put("QTY", rs.getInt("ITM_QTY"));
				ps.close();
				return retMap;
			}
			ps.close(); //cursor exceed ... 오류발생하기에 꼭 닫아줘야한다
			return null;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	
	}
	
}
