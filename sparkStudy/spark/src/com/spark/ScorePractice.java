package com.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.api.java.function.Function;

public class ScorePractice{

	public static void main(String[] args) {
		//ȯ�漳��
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("ScorePractice");
		//RDD���
		JavaSparkContext sc = new JavaSparkContext(conf);
		//DataFrame ���
	    SQLContext spark = new SQLContext(sc);
	
	    //read a score.txt file
	    JavaRDD<String> rdd = sc.textFile("C:\\Users\\seobi\\eclipse-workspace\\spark\\src\\com\\spark\\score.txt");
	    //a1,�ʵ�,20,40,50
	    JavaRDD<ScoreData> rdd1 = rdd.map(new Function<String, ScoreData>() {
			@Override
			public ScoreData call(String v1) throws Exception {
				String arr [] = v1.split(",");
				return new ScoreData(
						arr[0],
						arr[1],
						Integer.parseInt(arr[2]),
						Integer.parseInt(arr[3]),
						Integer.parseInt(arr[4]));
			}
	    });

	  //RDD TO DF���� ����
	  Dataset<Row> df = spark.createDataFrame(rdd1, ScoreData.class);
	  df.printSchema();//��Ű�� Ȯ��
	  df.show();//������ Ȯ��
	}
}
