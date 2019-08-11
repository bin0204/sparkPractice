package com.spark;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import scala.Tuple2;

public class StreamMain {

	public static void main(String[] args) {
		
		try {                                           //������ �����̶� ��ü �����带 �� ����Ҽ� �ֵ��� *�� �����ϱ�
			SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("StreamMain");
			//RDD���
			JavaSparkContext sc = new JavaSparkContext(conf);
			
			//SQLContext spark = new SQLContext(sc);
			JavaStreamingContext ssc = new JavaStreamingContext(sc, Durations.seconds(3));
			
			JavaReceiverInputDStream<String> lines = ssc.socketTextStream("localhost", 1236);
			
			//real-time ������ ó��
			lines.print();
			JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {

				//aaa, bbb, ccc, ddd�� ����
				@Override
				public Iterator<String> call(String t) throws Exception {
					return Arrays.asList(t.split(" ")).iterator();
				}
			});
			words.print();
			//(aaa,1) (bbb,1) (ccc,1) ....����
			JavaPairDStream<String, Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {
				@Override
				public Tuple2<String, Integer> call(String t) throws Exception {
					return new Tuple2<String, Integer>(t,1);
				}
			});
			
			pairs.print();
			//(aaa,2) (bbb,1) ...
			JavaPairDStream<String, Integer> wordCount = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
				@Override
				public Integer call(Integer v1, Integer v2) throws Exception {
					return v1+v2;
				}
			});
			
			wordCount.print();
			System.out.println("TEST");
			//lines.print();
			
			ssc.start(); // stream ����
			ssc.awaitTermination(); //���α׷��� ������� �ʰ� ����
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
