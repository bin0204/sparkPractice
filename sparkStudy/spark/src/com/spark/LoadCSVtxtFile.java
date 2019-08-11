package com.spark;

import static org.apache.spark.sql.functions.avg;
import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.sum;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;


public class LoadCSVtxtFile {
	public static void main(String[] args) {
		
		//��ü ���� conf
		//conf ��ü�� ���ؼ� set
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("LoadCSVtxtFile");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext spark = new SQLContext(sc);
		
//		JavaRDD<String> rdd = sc.textFile("C:\\Users\\seobi\\Desktop\\csv1.tt");
//		
//		System.out.println(rdd.collect());
		/***************************************************************************/
		//csv1.txt
		JavaRDD<String> text = sc.textFile("hdfs://175.126.73.18:9000/test2/csv1.txt");
		
		final String header = text.first();
		
		//System.out.println(header);
		
		JavaRDD<String> texts = text.filter(new Function<String, Boolean>() {
			@Override
			public Boolean call(String v1) throws Exception {
				return !v1.equalsIgnoreCase(header);
			}
		});
		
		//System.out.println(texts.collect());
		
		
		JavaRDD<CsvFile1> rdd1 = texts.map(new Function<String, CsvFile1>() {
			@Override
			public CsvFile1 call(String v1) throws Exception {
				String arr[] = v1.split(",");
				return new CsvFile1(
						Integer.parseInt(arr[0]),
					    arr[1],
					    Integer.parseInt(arr[2]),
					    arr[3],
					    arr[4]);
			}
	    });
		
		/***************************************************************************/
		//csv2.txt
		JavaRDD<String> text2 = sc.textFile("hdfs://175.126.73.18:9000/test2/csv2.txt");
		final String header2 = text2.first();
		
		//System.out.println(header2);
		//System.out.println(texts2.collect());
		JavaRDD<String> texts2 = text2.filter(new Function<String, Boolean>() {
			@Override
			public Boolean call(String v1) throws Exception {
				return !v1.equalsIgnoreCase(header2);
			}
		});
	
		JavaRDD<CsvFile2> rdd2 = texts2.map(new Function<String, CsvFile2>() {

			@Override
			public CsvFile2 call(String v1) throws Exception {
				String arr[] = v1.split(",");
				return new CsvFile2(
						Integer.parseInt(arr[0]),
					    arr[1],
					    Integer.parseInt(arr[2]),
					    Integer.parseInt(arr[3]),
					    arr[4]);
			}
	    	
	    });
		
	    //RDD TO DF���� ����
		Dataset<Row> df = spark.createDataFrame(rdd1, CsvFile1.class);
	    //df.printSchema();
	    //df.show();
	    
	    Dataset<Row> df2 = spark.createDataFrame(rdd2, CsvFile2.class);
	    //df2.printSchema();
	    //df2.show();
	    
	    
	    //query������ �ϱ� 
	    spark.registerDataFrameAsTable(df, "df");
	    spark.registerDataFrameAsTable(df2, "df2");
	    
	    //spark.sql("SELECT * FROM df INNTER JOIN df ON df.id = df2.id").show();
	    //spark.sql("SELECT date, sum(score) sum_score FROM df1 GROUP BY date").show();
	    //spark.sql("SELECT date, count(score) sum_count FROM df1 GROUP BY date").show();
	    
	    //df2�� �ִ� score���� 5000���� ū no�� title�� ����Ͻÿ�
	    spark.sql("SELECT no, title FROM df2 WHERE score > 5000").show();
	    
	    //RANK is a temporary value calculated when the query is run
	    spark.sql("SELECT no, score, "
	    		+ "RANK() OVER(ORDER BY score DESC) as rank_score "
	    		+ "FROM df2").show();
	    
	    
	    //DataFrame df3 = df.join(df2);
	    //df3.show();
	
	    //inner join ������
	    //DataFrame df22 = df.join(df2, df.col("id").equalTo(df2.col("id")), "inner");
	    
	    //outer join ������
	    //df.join(df2, df.col("id").equalTo(df2.col("id")), "outer").show();
	    
	    //df ����
	    //df.join(df2, df.col("id").equalTo(df2.col("id")), "leftinner").show();
	    
	    //df2 ����
	   // df.join(df2, df.col("id").equalTo(df2.col("id")), "rightinner").show();
	    
	    //���� : ��¥ ����̳� �ִ��� Ȯ���ϱ�
	    //CREATE ==> DF1 : InvoieNo, StockCode, UnitPrice �÷��� ����
	    //DataFrame df1 = df2.select("date");
	    //df1.show();
	 
	    //�׷����� ���� : ��ϵ� ��¥ �Խù� �� 
//	    Map<String, String> map = new HashMap<String, String>();
//	    map.put("date", "count");
//	   // map.put("title", "count");
//	    df1.groupBy(col("date")).agg(map).show();
	    
	}
}


