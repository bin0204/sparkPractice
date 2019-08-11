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

public class LoadJSon {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setMaster("local[1]")
				.setAppName("LoadJSON");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext spark = new SQLContext(sc);
		
		String url = "http://127.0.0.1:8080/web/json/chart2?key=abc";
		String jsonStr = Source.fromURL(url, 
				new Codec(Charset.forName("UTF-8"))).mkString();
		System.out.println(jsonStr);
		
		//String -> RDD�� ����
		JavaRDD<String> rdd = sc.parallelize(Arrays.asList(jsonStr));
		Dataset<Row> df = spark.read().option("multiline", "true").json(rdd);
		//ctrl + shift + o
		Dataset<Row> df1 = df.select(explode(col("data")));
		
		Dataset<Row> df2 = df1.select(
				col("col.year"),
				col("col.value"),
				col("col.value1"));
		
		df2.printSchema();
		df2.show(false);
	}

}
