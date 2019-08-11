package com.spark;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class RDDMain6 {

	public static void main(String[] args) {	//환경설정
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("RDDMain6");
		//RDD사용
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,1,1,2));
		
		JavaRDD<Integer> rdd1 = sc.parallelize(Arrays.asList(1,4,5));
		
		//중복제거
		JavaRDD<Integer> rdd2 = rdd.distinct();
		System.out.println(rdd2.collect());//1,2,3,4
		
		//차집합
		JavaRDD<Integer> rdd3 = rdd.subtract(rdd1);
		System.out.println(rdd3.collect());
		
		//합집합
		JavaRDD<Integer> rdd4 = rdd.union(rdd1);
		System.out.println(rdd4.collect());
		
		//교집합
		JavaRDD<Integer> rdd5 = rdd.intersection(rdd1);
		System.out.println(rdd5.collect());
		
		List<Tuple2<String, Integer>> data = Arrays.asList(
				new Tuple2("a",1), 
				new Tuple2("b",1), 
				new Tuple2("c",1));
		JavaPairRDD<String, Integer> rddp = sc.parallelizePairs(data);
		
		List<Tuple2<String, Integer>> data1 = Arrays.asList(
				new Tuple2("b",2), 
				new Tuple2("c",2), 
				new Tuple2("d",2));
		JavaPairRDD<String, Integer> rddp1 = sc.parallelizePairs(data1);
		//Cartesian Product
		
		//join
		JavaPairRDD<String, Tuple2<Integer, Integer>> rddp2 = rddp.join(rddp1);
		
		System.out.println(rddp2.collect());
	  }
}
