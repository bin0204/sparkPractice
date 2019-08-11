package com.java;

import java.io.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.SQLContext;

import com.spark.Member1;

public class Main {

	public static void main(String[] args) {

		//DB����
		Connection conn = DBConn.connectOralce();
		//INSERT
	 	DBInsert insert = new DBInsert();
		//System.out.println(conn);
		
		//������ �о DB�� ����
		//C:\Users\seobi\Desktop\data\2011-12-09.
		//�߰��� �ӽõ�����	
		try {
			File file = new File("C:/Users/seobi/Desktop/data/2011-12-09.csv");
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader fsr = new InputStreamReader(fis,"UTF-8");
			BufferedReader br = new BufferedReader(fsr); 
			int n = 0; //�ʱ�ȭ ��
			while(true) {//���� �ݺ�
				String line = br.readLine(); //���پ� �о line�� ����
				if(line == null) { //���� ������ ���ٸ�
					break; // �ݺ��� Ż��
				}
				n++;
				if(n==1) {//0�̸� �Ʒ��� �������
					continue;
				}
				System.out.println(line);
				String[] arr = line.split(",");
				
				if(arr.length == 8) {
					Map<String, Object> map2 = new HashMap<String, Object>();
					map2.put("in", arr[0]);
					map2.put("st", arr[1]);
					map2.put("des", arr[2]);
					map2.put("qua", Integer.parseInt(arr[3]));
					map2.put("ind", arr[4]);
					map2.put("unit", Float.parseFloat(arr[5]));
					if(arr[6].equals("") ) {
						arr[6] = "0";
					}
					map2.put("cus", Float.parseFloat(arr[6]));
					map2.put("con", arr[7]);
					
					insert.insert20111209CSV(conn, map2);
				}
				//ps.setInt(1, (Integer) map.get("in"));
			}
			System.out.println("DONE!");
				//20111209CSV ���̺� �����
				//line�� �ִ� ���ڿ��� , �� ����
				//InvoiceNo,StockCode,Description,Quantity,InvoiceDate,UnitPrice,CustomerID,Country
				//System.out.println("test" + lines);
				//map�� ����
				//DBInsert �� insert20111209() ȣ��	
				//Map<String, Object> map2 = new HashMap<String, Object>();
				//map2.put(key, value)
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Map<String, Object> map = new HashMap<String, Object>();
//		map.put("ename", "smith");
//		map.put("job", "student");
//		map.put("sal", 20);
//		map.put("comm", 10);	 
		//insert.insertBonusOne(conn, map); //DB��������, �߰��� ��
		//insert.insert20111209CSV(conn, map2);	
	}
}
