package com.spark;

import static org.apache.spark.sql.functions.*;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

import scala.io.Codec;
import scala.io.Source;

public class LoadJSONPractice {

	public static void main(String[] args) {
		
		
		SparkConf conf = new SparkConf().setMaster("local[1]")
				.setAppName("LoadJSON");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext spark = new SQLContext(sc);
		
		String url = "http://ihongss.com/demo/ajax_member_list3.json";
		String jsonStr = Source.fromURL(url, 
				new Codec(Charset.forName("UTF-8"))).mkString();
		System.out.println(jsonStr);
		//���������������� ����
				//{ret:, data:[] data1:[]}
				//DataFrame df3 = df1. unionAll(df2);
		//String -> RDD�� ����
		JavaRDD<String> rdd = sc.parallelize(Arrays.asList(jsonStr));
		Dataset<Row> df = spark.read().option("multiline", "true").json(rdd);
		df.printSchema();
		
		Dataset<Row> df1 = df.select(explode(col("data")));
		Dataset<Row> df2 = df.select(explode(col("data1")));
		
	    df1.printSchema();
	    Dataset<Row> df11 = df1.select(
				col("col.id"),
				col("col.age"),
				col("col.name")
				);
	
		df11.printSchema();
		df11.show();
		
		
		Dataset<Row> df22 = df2.select(
				col("col.id"),
				col("col.age"),
				col("col.name")
				);
	
		df22.printSchema();
		df22.show();
		
		Dataset<Row> df3 = df11.unionAll(df22);
		df3.printSchema();
		df3.show(false);
		//ctrl + shift + o
//		DataFrame df1 = df.select(explode(col("data")));
//		
//		DataFrame df2 = df1.select(
//				col("col.year"),
//				col("col.value"),
//				col("col.value1"));
//		DataFrame df3 = df1.unionAll(df2);
//		df3.printSchema();
//		df3.show(false);
		
		df3.write().format("csv").save("c:/Users/seobi/Desktop/data/"+System.currentTimeMillis());
	}
}
