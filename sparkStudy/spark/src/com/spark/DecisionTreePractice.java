package com.spark;

import static org.apache.spark.sql.functions.avg;
import static org.apache.spark.sql.functions.sum;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.ml.Pipeline;
import org.apache.spark.ml.PipelineModel;
import org.apache.spark.ml.PipelineStage;
import org.apache.spark.ml.clustering.KMeans;
import org.apache.spark.ml.feature.StringIndexer;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class DecisionTreePractice {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("DecisionTreePractice");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext spark = new SQLContext(sc);
		HiveContext spark1 = new HiveContext(sc);
		
		Dataset<Row> df = spark.read().format("csv")
	    		.option("header", "true")
	    		.option("delimiter", ",")
	    		.option("interSchema","true")
	    		.option("encoding", "UTF-8")
	    		.load("hdfs://175.126.73.18:9000/test2/decision_tree.csv");

		//df.printSchema();
		df.show();
	
		//DF1 => 년도, 월, 도로명, 평일평균교통량, 월간평일평균속도,일요일(휴일포함),월요일,화요일,수요일,목요일,금요일,토요일
		
		spark1.registerDataFrameAsTable(df, "df");
		
		Dataset<Row> df1 = spark1.sql("SELECT * FROM df");
		df1.show();
//		
//		
		//DF2 => 도로명별 월간평일평균속도의 평균 구하기(소수점 1자리에서 반올림) "avr_velo_total" 컬럼 추가
//		//DataFrame df2 = spark1.sql("SELECT road, avg_traffic_month, ROUND(avg(avr_traffic_month),1) AS avr_velo_total FROM df GROUP BY road");
//		DataFrame df2 = spark1.sql("SELECT year FROM df");
//		df2.show();
//		
		//DF3 => 도로명별 각 요일별 평균 속도 구하기
		//DataFrame df3 = spark1.sql("SELECT avg(sun), avg(mon), avg(tue), avg(wed), avg(thu), avg(fri), avg(sat) FROM df GROUP BY road");
		//df3.show();
		
		//DF4 = DF2 + DF3 => 월간평일평균속도와 도로명별월간평일평균 속도를 도로명을 기준으로 inner join
		//DataFrame df4 = spark1.sql("SELECT * FROM df2 INNTER JOIN df3 WHERE df2.road = df3.road");
		//df4.show();
		
		//DF5 => 월간평일평균속도, 도로명별월간평일평균속도를 비교하여 월간평일평균속도가 빠르면 "label" 컬럼에 1.0(원할),  아니면 0.0(지연)으로 처리
/*
		//DataFrame df5 = spark1.sql("SELECT * FROM df4 CASE
															WHEN avr_velo_total > _")
		*/
		//DF6 => DF5에서 label별 count 출력 (컬럼 : "road", "avr_velo_month", "avr_velo_total", "label") 
		
		
		
	 
	     
	  

	}

}
