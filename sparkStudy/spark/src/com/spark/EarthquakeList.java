package com.spark;

import java.util.Arrays;
import java.util.function.Function;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class EarthquakeList {

	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder().appName("EarthquakeList")
										.master("local[*]")
										.enableHiveSupport()
										.getOrCreate();

//
		Dataset<Row> df = spark.read().format("csv")
								.option("header", "true")
								.option("delimiter", ",")
								.option("interSchema","true")
								.option("encoding", "UTF-8")
								.load("C:\\Users\\seobi\\Downloads\\earthquakeList.csv");
		df.printSchema();
		df.show();
//		
		//2. header 없애기
		JavaRDD<String> rdd1 = df.filter(new Function<String, Row>(){
			@Override
			public Boolean call(String v1) throws Exception {
				if (v1.startsWith("\uFEFF")) {
					v1 = v1.substring(1);
					return false;
				}
				if(v1.startsWith("번호")) {
					return false;
				}
				return true;
			}
		});
		System.out.println(rdd1.collect());
		
//		//3. split to Row 생성
		JavaRDD<Row> rdd2 = rdd1.map(new Function<String, Row>(){
			public Row call(String v1) throws Exception {
				String[] arr = v1.split(",");
				return RowFactory.create(
						arr[0], //번호
						arr[1], //발생시각
						Integer.parseInt(arr[2]), //규모
						arr[3], //깊이 -> 제거
						arr[4], //위도 latitude
						arr[5], //경도 longitude
						arr[6] //위치
				);
			}
		});
		
		System.out.println(rdd2.collect());
//		//3. 스키마 만들기
		StructField sf1 = DataTypes.createStructField("no", DataTypes.StringType, true);
		StructField sf2 = DataTypes.createStructField("time", DataTypes.StringType, true);
		StructField sf3 = DataTypes.createStructField("scale", DataTypes.IntegerType, true);
		StructField sf4 = DataTypes.createStructField("depth", DataTypes.StringType, true);
		StructField sf5 = DataTypes.createStructField("lat", DataTypes.StringType, true);
		StructField sf6 = DataTypes.createStructField("log", DataTypes.StringType, true);
		StructField sf7 = DataTypes.createStructField("loc", DataTypes.StringType, true);
//

//		//데이터 프레임 생성
		StructType schema = DataTypes.createStructType(Arrays.asList(sf1,sf2,sf3,sf5,sf6,sf7));
		Dataset<Row> df1 = spark.createDataFrame(rdd2, schema);
		df1.show(false);

	}

}
