package com.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;
import static org.apache.spark.sql.functions.*;


public class LoadOracle {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("LoadOracle");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext spark = new SQLContext(sc);
		
		Dataset<Row> df = spark.read().format("jdbc")
				.option("url", "jdbc:oracle:thin:@127.0.0.1:1521:xe")
				.option("dbtable", "dept")
				.option("user", "hr")
				.option("password", "oracle")
				.option("driver", "oracle.jdbc.driver.OracleDriver")
				.load();
		
		df.printSchema();
		df.show();
		
		//member_t��� �ӽ����̺� ����
		df.registerTempTable("member_t");
		//spark.sql("SELECT DEPTNO, DNAME FROM member_t").show();
		//ID, PW, NAME�� �����ͼ� ID������ �������� DESC
		//df2�� ��Ƽ� ���
//		DataFrame df2 = spark.sql("SELECT DEPTNO, DNAME FROM member_t ODER BY DEPTNO DESC");
//		df2.show();
		
		//df���� �÷����� id, pw�ΰ͸� ���
		Dataset<Row> df1 = df.select(col("DEPTNO"));
		df1.show();
		
		Dataset<Row> df2 = spark.sql("SELECT DEPTNO, DNAME FROM member_t order by deptno DESC");
		df2.show();
	}

}
