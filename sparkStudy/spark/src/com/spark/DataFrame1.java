package com.spark;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.spark.sql.functions.*; 
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class DataFrame1 {

	public static void main(String[] args) {
		//ȯ�漳��
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("RDDMain4");
		//RDD���
		JavaSparkContext sc = new JavaSparkContext(conf);
		//DataFrame ���
		SQLContext spark = new SQLContext(sc);
		
		Board1 b1 = new Board1(1,"title1","ddddfsdfdfs","writer1",122,"2019-04-26");
		Board1 b2 = new Board1(2,"title2","dfsdfserdadfdf","writer2",12,"2019-04-26");
		Board1 b3 = new Board1(3,"title3","dddfdfadfadfadadfddfsdfdfs","writer3",323,"2019-08-29");
		
		System.out.println(b1.toString());
		
		List<Board1> list = Arrays.asList(b1,b2,b3);
		
		Dataset<Row> df1 = spark.createDataFrame(list, Board1.class);
		
		//df1.printSchema();
		//df1.show(false);
		
		//Column �߰� title�� ������ �����ͼ� add_title�� �߰�
		df1.withColumn("add_title",col("title")).show();
		
		//�ִ밪
		df1.select(max("hit")).show();
		
		//title���� ��ȣ, ����, ���� ���
		df1.select("no","title","content").show();
		
		//title�� title1�� ���� �� �͸� ���
		df1.where(col("title").isin("title1","title2")).show(); //������ ����
		df1.filter(col("title").contains("title3")).show(); //�Ѱ��� ����
		
		//��ȸ�� �������� ����
		df1.orderBy(col("hit")).show();
		
		//Ư�� ���� �ٲٱ�
		Map<String, String> map = new HashMap<String, String>();
		map.put("title1", "ctitle1");
		map.put("title2", "ctitle2");
		map.put("title3", "ctitle3"); //�ٲܳ��� ����
		df1.na().replace(new String [] {"title"}, map).show();
		
		
		//�׷����� ���� : ��ϵ� ��¥ �Խù� �� 
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("no", "count");
		map1.put("no", "sum");
		df1.groupBy(col("date")).agg(map1).show();
		
		//��ȸ���� 100��  ���ϰ� ^2 �� ���� 5�� ���� ����� pow �÷��� �߰�
		//df1.selectExpr("*","(POWER((hit+100),2.0+5) as pow").show();
		//date�� ��¥ Ÿ������ ��ȯ�Ͽ� covert_datatype �ʵ� �߰�
		//df1.withColumn("convert_datetype", date_format(col("date"),"yyyy/MM/dd HH:mm:ss")).show();
		
		
		//Create one more column => df1 => df1_1
		//����ؼ� ����� 1000�� ���� �ؾ���
	}

}
