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
			
			//int ret = ps.executeUpdate() insert, update, delete�϶� ����ϴ� �� (���� ��ȯ)
			ResultSet rs = ps.executeQuery(); //SELECT
			while(rs.next()) {//�����Ͱ� �ִٸ�
				//map�� �ؾ��Ѵ� main�� �����ֱ� ���ؼ� 
				Map<String, Object> retMap = new HashMap<String, Object>();
				retMap.put("ID", rs.getString("MEM_ID"));
				retMap.put("NAME", rs.getString("MEM_NAME"));
				retMap.put("EMAIL", rs.getString("MEM_EMAIL"));
				ps.close();
				return retMap;
			}
			ps.close(); //cursor exceed ... �����߻��ϱ⿡ �� �ݾ�����Ѵ�
			return null;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	//SHOP ITEM �������� METHOD
	
	public Map<String, Object> selectShopItemOne(Connection conn, Map<String, Object> map) {
		try {
			String sql = "SELECT * FROM SHOP_ITEM WHERE ITM_NO=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, (String) map.get("NO"));
			
			//int ret = ps.executeUpdate() insert, update, delete�϶� ����ϴ� �� (���� ��ȯ)
			ResultSet rs = ps.executeQuery(); //SELECT
			while(rs.next()) {//�����Ͱ� �ִٸ�
				//map�� �ؾ��Ѵ� main�� �����ֱ� ���ؼ� 
				Map<String, Object> retMap = new HashMap<String, Object>();
				retMap.put("NO", rs.getString("ITM_NO"));
				retMap.put("NAME", rs.getString("ITM_NAME"));
				retMap.put("PRICE", rs.getInt("ITM_PRICE"));
				retMap.put("QTY", rs.getInt("ITM_QTY"));
				ps.close();
				return retMap;
			}
			ps.close(); //cursor exceed ... �����߻��ϱ⿡ �� �ݾ�����Ѵ�
			return null;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	
	}
	
}
