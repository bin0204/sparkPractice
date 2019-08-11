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

public class HelloCheck {

	public static void main(String[] args) {
		try {                                           //������ �����̶� ��ü �����带 �� ����Ҽ� �ֵ��� *�� �����ϱ�
			SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("HelloCheck");
			//RDD���
			JavaSparkContext sc = new JavaSparkContext(conf);
			
			//SQLContext spark = new SQLContext(sc);
			JavaStreamingContext ssc = new JavaStreamingContext(sc, Durations.seconds(3));
			
			JavaReceiverInputDStream<String> lines = ssc.socketTextStream("1.234.5.158", 9999);
			
			//real-time ������ ó��
			lines.print();
			
			JavaDStream<String> hello = lines.flatMap(new FlatMapFunction<String, String>() {
				@Override
				public Iterator<String> call(String t) throws Exception {
					return Arrays.asList(t).iterator();
				}
			});
			hello.print();
			
			//words.print();
			
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
