package com.spark;

import java.util.Arrays;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

public class SaverRedis {

	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder()
	            .appName("SAVERedis")
	            .master("local[*]")
	            .config("spark.redis.host", "127.0.0.1") //127.0.0.1
	            .config("spark.redis.port", "6379")
	            //.config("spark.redis.auth", "redis77")
	            .enableHiveSupport()
	            .getOrCreate();

			Member1 m1 = new Member1("id1",13,"000-0000-0000");
			Member1 m2 = new Member1("id2",23,"000-0000-0001");
			Member1 m3 = new Member1("id3",34,"000-0000-0002");
			
			Dataset<Row> df = spark.createDataFrame(
					Arrays.asList(m1, m2, m3), Member1.class);
			
			df.show();
			
			//DF to redis에 저장
			df.write().format("org.apache.spark.sql.redis")
			.option("table", "seobin")
			.option("key.column", "id")
			.mode(SaveMode.Overwrite)
			.save();
			
			//redis to DF에 읽기
			
			spark.close();
	}

}
