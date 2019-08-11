package com.spark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import scala.Tuple2;

public class RemoveAPractice {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("RDDRemoveAPractice");
		JavaSparkContext sc = new JavaSparkContext(conf);
		//문제 a를 제거하시오
		//RDDD의 값 듀플 (1, "abc"), (2, "abbb") (3, "accc")
		//RDD1의 값 듀플 (1, "bc"), (2, "bbb"), (3, "ccc")
		
		Tuple2<Integer, String> rt1 = new Tuple2<Integer, String>(1,"abc");
		
		Tuple2<Integer, String> rt2 = new Tuple2<Integer, String>(2,"abbb");
		
		Tuple2<Integer, String> rt3 = new Tuple2<Integer, String>(3,"accc");
		
		List<Tuple2<Integer, String>> lis = new ArrayList<Tuple2<Integer, String>>();
		lis.add(rt1);
		lis.add(rt2);
		lis.add(rt3);
		
		JavaPairRDD<Integer, String> rddd = sc.parallelizePairs(lis);
		//Original Output: [(1,abc), (2,abbb), (3,accc)]
		System.out.println(rddd.collect());
		
		Function func1 = new Function<String, Iterable<String>>() {
			@Override
			public Iterable<String> call(String v1) throws Exception {
				String s = v1.replace("a", "");
				return Arrays.asList(s);
			}
		};
		
		JavaPairRDD<Integer,String> rdd1 = rddd.flatMapValues(func1);
		
		//Expected output: [(1,bc), (2,bbb), (3,ccc)]
		System.out.println(rdd1.collect());
	}

}
