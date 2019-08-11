package com.spark;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.date_format;
import static org.apache.spark.sql.functions.max;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class ItemDataReadPractice {

	public static void main(String[] args) {
		//RDD�� �о df
		//ȯ�漳��
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("ItemDataReadPractice");
		//RDD���
		JavaSparkContext sc = new JavaSparkContext(conf);
		//DataFrame ���
	    SQLContext spark = new SQLContext(sc);
	    
	    //read a item.txt file
	    JavaRDD<String> rdd = sc.textFile("C:\\Users\\seobi\\Desktop\\item.txt");
	    String UTF8_BOM = "\uFEFF";//�ѱ�
	    
	    
	    JavaRDD<Row> rdd1 = rdd.map(new Function<String, Row>() {
			@Override
			public Row call(String v1) throws Exception {
				String arr [] = v1.split(",");
				if(arr[0].startsWith(UTF8_BOM)) {
					arr[0] = arr[0].substring(1);
				}
				System.out.println(v1);
				return RowFactory.create(
						arr[0], //itmNo
						arr[1], //itmName
						Integer.parseInt(arr[2]), //itmprice
						Integer.parseInt(arr[3]), //itmqty
						arr[4]); //itmDate
			}
	    });
//	    

	    System.out.println(rdd1.collect());
	  //�÷����� ���� ����Ʈ
	  	List<StructField> fields = new ArrayList<StructField>();
	  	
	  //ù��° �÷� : ID String, null ����
  		StructField f1 = DataTypes.createStructField("ItmNo", DataTypes.StringType, true);
  		StructField f2 = DataTypes.createStructField("ItmName", DataTypes.StringType, true);
  		StructField f3 = DataTypes.createStructField("ItmPrice", DataTypes.IntegerType, true);
  		StructField f4 = DataTypes.createStructField("ItmQty", DataTypes.IntegerType, true);
  		StructField f5 = DataTypes.createStructField("ItmDate", DataTypes.StringType, true);
  		
  		fields.add(f1);
  		fields.add(f2);
  		fields.add(f3);
  		fields.add(f4);
  		fields.add(f5);
//  		
//  		//��Ű�� ����
		StructType schema = DataTypes.createStructType(fields);
 		//DataFrame df1 = spark.createDataFrame(rdd1, schema);
	  

//	  //RDD TO DF���� ����
	  Dataset<Row> df = spark.createDataFrame(rdd1, schema);
	  //DataFrame df1 = spark.createDataFrame(rdd3, OrderData.class);
	  df.printSchema();//��Ű�� Ȯ��
	  df.show();
	  df.selectExpr("*","(1000-ItmQty) as itmAddQty").show();


	  //df1.printSchema();
	  
			    
	  //������� �ֱ�
	  
	// itmAddQty = 1000 - itmqty
//	DataFrame df1_1 = df.selectExpr("*","((1000-itmQty)) as itmAddQty");
//	df1_1.show();
	}
}
