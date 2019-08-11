package com.spark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import scala.Tuple2;

public class WordCount {

	public static void main(String[] args) {
		
		//ȯ�漳��
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("WordCount");
		//RDD���
		JavaSparkContext sc = new JavaSparkContext(conf);
		//DataFrame ���
	    SQLContext spark = new SQLContext(sc);
	    
	    //�ؽ�Ʈ ���ڿ�
	    String str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
	    
	    //RDD ����
	    JavaRDD<String> rdd = sc.parallelize(Arrays.asList(str));
	    //System.out.println(rdd.collect());
	    
	    
	    //map: String -> String 
	    //flatMap: String -> List<String> (���ȭ)
	    //������ �������� ����
	    JavaRDD<String> rdd1 = rdd.flatMap(new FlatMapFunction<String, String>() {

			@Override
			public Iterator<String> call(String t) throws Exception {
				//������ �������� ������
				String arr[] = t.split(" ");
				return Arrays.asList(arr).iterator();
			}
	    });
	    System.out.println(rdd1.collect());
	    
	    
	    //mapToPair : key, valueŸ������ ������ key�� value�� ���� ���                        //���°��� string //������ ���� string + integer
	    JavaPairRDD<String, Integer> rdd2 = rdd1.mapToPair(new PairFunction<String, String, Integer>() {
			@Override                                         
			public Tuple2<String, Integer> call(String t) throws Exception {
				// ex) aaa => (aaa, 1), bbb => (bbb, 1)
				return new Tuple2<String, Integer>(t, 1);
			}
	    });
	    System.out.println(rdd2.collect());
	    
	    //using reduceByKey => counting the word by key                                    //����°���� �Ѿ�� ��    
	    JavaPairRDD<String, Integer> rdd3 = rdd2.reduceByKey(new Function2<Integer,Integer,Integer>() {	
			@Override
			public Integer call(Integer v1, Integer v2) throws Exception {
				return v1 + v2;
			}
	    });
	    System.out.println(rdd3.collect());
	    
	    //JavaRDD<Row> + schema -> DataFrame 
	    //JavaRDD<Bean> + schema -> DataFrame 
	    
	    //���� JavaPairRDD<String, Integer> => JavaRDD<Row> 
	    JavaRDD<Row> rdd4 = rdd3.map(new Function<Tuple2<String, Integer>, Row>(){
			@Override
			public Row call(Tuple2<String, Integer> v1) throws Exception {
				return RowFactory.create(v1._1,v1._2);
			}
	    });
	    System.out.println(rdd4.collect()); 
	    
	    //��Ű���� ������ ����Ʈ ����
	    List<StructField> fields = new ArrayList<StructField>();
	    
	    fields.add(DataTypes.createStructField("KEY", DataTypes.StringType, true));
	    fields.add(DataTypes.createStructField("VALUE", DataTypes.IntegerType, true));
	    
	    //��Ű�� ����
	    StructType schema = DataTypes.createStructType(fields);
	    //������������ ����
	    Dataset<Row> df = spark.createDataFrame(rdd4,schema);
	    df.printSchema();
	    df.show();
	}
}
