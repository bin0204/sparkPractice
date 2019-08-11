package com.spark;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.date_format;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.catalyst.expressions.FromUnixTime;
import org.apache.spark.sql.catalyst.expressions.UnixTimestamp;
import org.apache.spark.sql.hive.HiveContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class HivePractice1 {

	public static void main(String[] args) {
		//conf ��ü�� ���ؼ� set
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("HivePractice");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext spark = new SQLContext(sc);
		//HiveContext spark1 = new HiveContext(sc);
		
		//JavaRDD<String> text = sc.textFile("hdfs://175.126.73.18:9000/test2/201508_station_data.csv");
		
		List<StructField> fields1 = new ArrayList<StructField>();
		fields1.add(DataTypes.createStructField("stationId", DataTypes.StringType, true));
		fields1.add(DataTypes.createStructField("name", DataTypes.StringType, true));
		fields1.add(DataTypes.createStructField("lat", DataTypes.DoubleType, true));
		fields1.add(DataTypes.createStructField("lng", DataTypes.DoubleType, true));
		fields1.add(DataTypes.createStructField("dockCount", DataTypes.IntegerType, true));
		fields1.add(DataTypes.createStructField("landmark", DataTypes.StringType, true));
		fields1.add(DataTypes.createStructField("installation", DataTypes.StringType, true));

		StructType schema1 = DataTypes.createStructType(fields1);
		
		Dataset<Row> df2 = spark.read().format("csv")
				.option("header", "true")
				.option("delimiter", ",")
				.schema(schema1)
				.load("hdfs://175.126.73.18:9000/test2/201508_station_data.csv");
		//df2.show();
		
		
		//spark.registerDataFrameAsTable(df2, "df2");
		
		//landmark �� count ����
		//spark1.sql("SELECT landmark FROM df2").show();

		//date�� ��¥ Ÿ������ ��ȯ�Ͽ� covert_datatype �ʵ� �߰�
	    //df2.withColumn("format_installation", date_format(col("installation"),"yyyy-MM-dd")).show();
	    
		//df2.where(col("installation")).show(); //������ ����
		
		
		//installation ��¥ Ÿ�� ����
		
		//spark1.sql("SELECT landmark, installation, 
		//from_unixtime(unix_timestamp(installation ,'dd/MM/yyyy'),'yyyy/MM/dd') 
		//format_installation FROM df ").show();

		//2. landmark�� count ����
        //SELECT count(no) FROM df GROUP BY landmark
        
        //3. landmark�� dockcount ��/���
        //SELECT sum(no) FROM df GROUP BY landmark
        //SELECT avg(no) FROM df GROUP BY landmark
        
        //4. dockcount�� 20 ~ 30�� ��� 
        //SELECT * FROM df WHERE dockcount >= 20 AND dockcount <= 30
        
        //5. name�� "Park"�� ���Ե� ���
        //SELECT * FROM df WHERE name LIKE '%Park%'
		
	
		//installation ��¥ Ÿ�� ����
//		df2.select(
//				col("landmark"),
//				col("installation")).withColumn("format_installation", (date_format(col("installation"), "yyyy-mm-dd"))).show();
//		//UnixTimestamp ux = new UnixTimestamp();
		
		
		//spark1.sql("SELECT landmark, installation, 
				//from_unixtime(unix_timestamp(installation ,'dd/MM/yyyy'),'yyyy/MM/dd') 
				//format_installation FROM df ").show();
		
		//landmark�� count ����
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("installation", "count");
		df2.groupBy(col("installation")).agg(map1).show();
		
		//landmark�� dockcount ��/���
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("dockCount", "sum");
		df2.groupBy(col("installation")).agg(map2).show();
		
		map2.put("dockCount", "avg");
		df2.groupBy(col("installation")).agg(map2).show();
		
		// dockcount�� 20 ~ 30�� ��� 
		df2.select(
				col("dockCount"),
				col("landmark"))
				.where(col("dockCount").between(20, 30)).show();

		// name�� "Park"�� ���Ե� ���
		df2.select(
				col("name"), 
				col("landmark"))
			.filter(col("name").contains("Park")).show();
		//SELECT * FROM df2 WHERE name LIKE '%Park%'
	}


	//spark1.sql("SELECT landmark, installation, 
			//from_unixtime(unix_timestamp(installation ,'dd/MM/yyyy'),'yyyy/MM/dd') 
			//format_installation FROM df ").show();
	


}
