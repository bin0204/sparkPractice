package com.spark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.*;

import scala.Tuple2;


public class RDDMain2 {

	public static void main(String[] args) {
		//p.117~ 
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("RDDMain2");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		//튜플 생성
		Tuple2<Integer, String> t1 = new Tuple2<Integer, String>(1,"a");
		
		Tuple2<Integer, String> t2 = new Tuple2<Integer, String>(2,"b");
		
		Tuple2<Integer, String> t3 = new Tuple2<Integer, String>(3,"c");
		
		//리스트에 추가
		List<Tuple2<Integer, String>> list = new ArrayList<Tuple2<Integer, String>>();
		list.add(t1);
		list.add(t2);
		list.add(t3);
		
		
		// output [(1,a), (2,b), (3,c)]
		//List to RDD
		JavaPairRDD<Integer, String> rdd = sc.parallelizePairs(list);
		//Return an array that contains all of the elements in this RDD.
		//System.out.println(rdd.collect());
		
		
		//arg1 넘어오는 값, 리턴값
		//인터페이스이기때문에  overriding 필요
		Function func = new Function<String, Iterable<String>>() {
			@Override
			public Iterable<String> call(String v1) throws Exception {
				// Changed output: [(1,a_), (2,b_), (3,c_)]
				return Arrays.asList(v1 + "_"); 
			}
		};
	
		//The expression of type JavaPairRDD needs unchecked conversion
        // to conform to JavaPairRDD<Integer,String>
		JavaPairRDD<Integer,String> rdd1 = rdd.flatMapValues(func);
		System.out.println(rdd1.collect());
/*----------------------------------------------------------------------------------------------*/		
		
	}
}
