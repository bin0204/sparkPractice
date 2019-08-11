package com.java;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DBConn {
	public static Connection connectOralce() {
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String id = "hr";
			String pw = "oracle";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			return conn;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}	
	}
}
