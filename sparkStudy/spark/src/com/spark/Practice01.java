package com.spark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

public class Practice01 {

	public static void main(String[] args) {
		
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("RDDPractice01");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		List<String> list = new ArrayList<String>();
		list.add("1, ������, 30");
		list.add("2, ������, 31");
		list.add("3, ������, 32");
		
		//split by ","
		JavaRDD<String> rdd = sc.parallelize(list);
	
		JavaRDD<String> rdd1 = rdd.flatMap(new FlatMapFunction<String, String>() {
			@Override
			public Iterator<String> call(String t) throws Exception {
				//String arr  = t.replaceAll("\\s", ""); //(",\\s", "")
				String arr[] = t.split(",");
				for(int i=0;i<arr.length;i++) {
					arr[i] = arr[i].trim();
				}
				return Arrays.asList(arr).iterator();
			}
		});
		System.out.println(rdd1.collect());
		
		//The other way
		//using lambda expression
		JavaRDD<String> rdd3 = rdd.flatMap((String t) -> Arrays.asList(t.split(",\\s")).iterator());
	
		//output : element with newline
		for(String r:rdd3.collect()) {
			System.out.println(r);
		}
	}
}
