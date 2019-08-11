package com.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import static org.apache.spark.sql.functions.*;
import org.apache.spark.sql.Column;

public class StockPractice {

	public static void main(String[] args) {
		//ȯ�漳��
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("StockPractice");
		//RDD���
		JavaSparkContext sc = new JavaSparkContext(conf);
		//DataFrame ���
	    SQLContext spark = new SQLContext(sc);
	    
	    //CSV ���� �б�
	    Dataset<Row> df = spark.read().format("csv")
	    		.option("header", "true")
	    		.option("delimiter", ",")
	    		.option("interSchema","true")
	    		.option("encoding", "UTF-8")
	    		/*���� ��Ű�� ����*/
	    		//.schema(schema)
	    		.load("C:\\Users\\seobi\\Desktop\\data\\2011-12-09.csv");
	    
	    
	    //20���� ����ϱ�
	    //df.printSchema();
	    df.show(20,false);
	    
	    //CREATE ==> DF1 : InvoieNo, StockCode, UnitPrice �÷��� ����
	    Dataset<Row> df1 = df.select("InvoiceNo", "StockCode", "UnitPrice");
	    df1.show();
	 
	    //DF1�� unitPrice �հ� & ��� ���ϱ�
	    df1.select(sum("UnitPrice").as("UnitSum"),avg("UnitPrice").as("UnitAvg")).show();
	    //df1.select().show();
	    
	    System.out.println("test");
	}

}
