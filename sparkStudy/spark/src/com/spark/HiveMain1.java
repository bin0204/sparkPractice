package com.spark;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class HiveMain1 {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("HiveMain1");
		//RDD���
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		SQLContext spark = new SQLContext(sc);
		HiveContext spark1 = new HiveContext(sc);
		
		List<StructField> fields1 = new ArrayList<StructField>();
		fields1.add(DataTypes.createStructField("no", DataTypes.IntegerType, true));
		fields1.add(DataTypes.createStructField("title", DataTypes.StringType, true));
		fields1.add(DataTypes.createStructField("id", DataTypes.IntegerType, true));
		fields1.add(DataTypes.createStructField("score", DataTypes.IntegerType, true));
		fields1.add(DataTypes.createStructField("date", DataTypes.StringType, true));

		StructType schema1 = DataTypes.createStructType(fields1);
		
		Dataset<Row> df2 = spark.read().format("csv")
				.option("header", "true")
				.option("delimiter", ",")
				.schema(schema1)
				.load("hdfs://175.126.73.18:9000/test2/csv2.txt");
		df2.show();
		
		spark1.registerDataFrameAsTable(df2, "df2");
		
		spark1.sql("SELECT no, score, "
	    		+ "RANK() OVER(ORDER BY score DESC) as rank_score "
	    		+ "FROM df2").show();
		
//		spark1.sql("SELECT no, score, "
//	    		+ "RANK() OVER(ORDER BY score DESC) as rank_score "
//	    		+ "FROM df2").show();
		
	}
}
