package com.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

public class DBInsert {
	public void insertBonusOne(Connection conn, Map<String, Object> map) {
		try {

			//INSERT DATA INTO DB
			String sql = "INSERT INTO BONUS (ENAME, JOB, SAL, COMM) VALUES(?,?,?,?)";
			
			//?에 값 추가
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, (String) map.get("ename"));
			ps.setString(2, (String) map.get("job"));
			ps.setInt(3, (Integer) map.get("sal"));
			ps.setInt(4, (Integer) map.get("comm"));
			
			//sql문 수행
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void insert20111209CSV(Connection conn, Map<String, Object> map) {
		try {
			//CREATE DATA INTO DB
			String sql = "INSERT INTO CSV2019(INVOICENO, STOCKCODE, DESCRIPTION, QUANTITY, INVOICEDATE, UNITPRICE, CUSTOMERID, COUNTRY) "
					+ "VALUES(?,?,?,?,?,?,?,?)";
			//?에 값을 추가
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, (String) map.get("in"));
			ps.setString(2, (String) map.get("st"));
			ps.setString(3, (String) map.get("des"));
			ps.setInt(4, (Integer) map.get("qua"));
			ps.setString(5, (String) map.get("ind"));
			ps.setFloat(6, (Float) map.get("unit"));
			ps.setFloat(7, (Float) map.get("cus"));
			ps.setString(8, (String) map.get("con"));
			
			//sql문 수행
			ps.executeUpdate();
			ps.close();
		}
		catch(Exception e ) {
			System.out.println(e.getMessage());
		}
	}
}
