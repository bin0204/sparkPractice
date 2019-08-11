package com.spark;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class RDDMain4 {

	public static void main(String[] args) {
		
		//ȯ�漳��
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("RDDMain4");
		//RDD���
		JavaSparkContext sc = new JavaSparkContext(conf);
		//DataFrame ���
		SQLContext spark = new SQLContext(sc);
		System.out.println("dfdf");
	
		//read .txt file
		JavaRDD<String> rdd = sc.textFile("C:\\Users\\seobi\\Desktop\\aaa.txt");
	    String UTF_BOM = "\nFEFF";
	    
		//System.out.println("dfdfddddd");
		System.out.println(rdd.collect());
		//Function<�Ķ����Ÿ��, ����Ÿ��>
		
		JavaRDD<Row> rdd1 = rdd.map(new Function<String, Row>() {
			@Override
			public Row call(String v1) throws Exception {
				
				//a1,14,010-0000-0001  => arr[0] = a1, arr[1] = 14
				String arr [] = v1.split(",");
				if(arr[0].startsWith(UTF_BOM)) {
					arr[0] = arr[0].substring(1);
				}
				System.out.println(v1);
				
				return RowFactory.create(arr[0], Integer.parseInt(arr[1]), arr[2]);
			}
		});
		
		System.out.println(rdd1.collect());
		
		//�÷����� ���� ����Ʈ
		List<StructField> fields = new ArrayList<StructField>();
		
		//ù��° �÷� : ID String, null ����
		StructField f1 = DataTypes.createStructField("int", DataTypes.StringType, true);
		StructField f2 = DataTypes.createStructField("AGE", DataTypes.IntegerType, true);
		StructField f3 = DataTypes.createStructField("TEL", DataTypes.StringType, true);
		
		fields.add(f1);
		fields.add(f2);
		fields.add(f3);
		
		//��Ű�� ����
		StructType schema = DataTypes.createStructType(fields);
		Dataset<Row> df = spark.createDataFrame(rdd1, schema);
		
		//��Ű�� Ȯ��
		df.printSchema();
		//������ Ȯ��
		df.show();
	}
}
