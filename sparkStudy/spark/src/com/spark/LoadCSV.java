package com.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class LoadCSV {

	public static void main(String[] args) {
		//ȯ�漳��
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("ScorePractice");
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
	    		.load("C:\\Users\\seobi\\Desktop\\data1.csv");
	    df.printSchema();
	    df.show();
	}
	
}
