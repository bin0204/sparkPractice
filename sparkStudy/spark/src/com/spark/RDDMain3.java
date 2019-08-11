package com.spark;

import java.util.*;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDMain3 {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("RDDMain3");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		//key로 사용할 리스트
		List<String> list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		JavaRDD<String> rdd1 = sc.parallelize(list1);
		
		//value로 사용할 리스트
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		JavaRDD<Integer> rdd2 = sc.parallelize(list2);
		
		//key + value
		JavaPairRDD<String, Integer> rdd3 = rdd1.zip(rdd2);
		System.out.println(rdd3.collect());
		
	
		
		
		
	}
}
