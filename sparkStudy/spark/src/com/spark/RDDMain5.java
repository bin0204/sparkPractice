package com.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class RDDMain5 {

	public static void main(String[] args) {
		
		//ȯ�漳��
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("RDDMain4");
		//RDD���
		JavaSparkContext sc = new JavaSparkContext(conf);
		//DataFrame ���
	    SQLContext spark = new SQLContext(sc);
	    
	  
	    JavaRDD<String> rdd = sc.textFile("C:\\Users\\seobi\\Desktop\\aaa.txt");
	    
	    	
	    //StringŸ���� ���� split�� ������ Member1Ÿ������ ����
	    /*
	     a1,14,010-0000-0001
		 a2,15,010-0000-0002
		 a3,16,010-0000-0003
	     */
	    JavaRDD<Member1> rdd1 = rdd.map(new Function<String, Member1>() {

			@Override
			public Member1 call(String v1) throws Exception {
				String arr[] = v1.split(",");
				return new Member1(arr[0],Integer.parseInt(arr[1]),arr[2]);
			}
	    	
	    });
	    //RDD TO DF���� ����
	    Dataset<Row> df = spark.createDataFrame(rdd1, Member1.class);
	    df.printSchema();
	    df.show();
	}

}
