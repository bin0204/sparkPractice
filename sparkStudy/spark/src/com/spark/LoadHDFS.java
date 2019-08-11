package com.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;

public class LoadHDFS {

	public static void main(String[] args) {
	
		//객체 생성 conf
		//conf 객체를 통해서 set
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("RDDMain1");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext spark = new SQLContext(sc);
		
		JavaRDD<String> rdd1 = sc.textFile("hdfs://175.126.73.18:9000/test1/a.txt");
		
		System.out.println(rdd1.collect());
		
		//HDFS로 저장
		rdd1.saveAsTextFile("hdfs://175.126.73.18:9000/test1/folder_bin");
		

	}

}
