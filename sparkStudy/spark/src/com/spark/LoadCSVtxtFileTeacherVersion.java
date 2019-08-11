package com.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.SQLContext;

public class LoadCSVtxtFileTeacherVersion {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("LoadCSVtxtFile");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext spark = new SQLContext(sc);
		
		JavaRDD<String> rdd = sc.textFile("hdfs://175.126.73.18:9000/test2/csv1.txt");
		
		System.out.println(rdd.collect());
		
//		List<String> list = rdd.collect();
//		for(int i = 0; i< list.size(); i++) {
//			if(i ==0) {
//				continue;
//			}
//			
//		}
		JavaRDD<String> rdd1 = rdd.filter(new Function<String, Boolean>() {

			@Override
			public Boolean call(String v1) throws Exception {
				if(v1.startsWith("id")) {
					return false;
				}
				return true;	
			}
		});
		
	}

}
