package com.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import static org.apache.spark.sql.functions.*;


public class CSVPractice {

	public static void main(String[] args) {
		//ȯ�漳��
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("CSVPractice");
		//RDD���
		JavaSparkContext sc = new JavaSparkContext(conf);
		//DataFrame ���
	    SQLContext spark = new SQLContext(sc);
	    
	    
	    //CSV ���� �ϱ�
	    Dataset<Row> df = spark.read().format("csv")
	    		.option("header", "true")
	    		.option("delimiter", ",")
	    		.option("interSchema","true")
	    		.option("encoding", "UTF-8")
	    		//load cancer file
	    		.load("C:\\Users\\seobi\\Desktop\\cancer1.csv");
	    		//���� ��Ű�� ����
	    //�÷��߰�
	    //�������� �߰�
	    //DataFrame df1 = df.withColumn("����", col("����"));\
	    
	    /* �ٸ� ��� ������ ���� ��� */
	    
	    //���̺�� ������ sql���� �����Ͽ� ��� �� ��ȯ
	    //df1.registerTempTable("table1");
	    //spark.sql("SELECT MAX(����(%)) FROM table1").show();
	    
	    //�����������ӿ��� select�� �̿��Ͽ� ��� �� ��ȯ
	    df.select(max("����(%)").as("Max_%")).show();
	    
	    
	    //df.printSchema();
	    //df.show(25);
	}

}
