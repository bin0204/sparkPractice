package com.spark;

import java.util.*;

import org.apache.spark.*;
import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.*;

public class RDDMain1 {

	public static void main(String[] args) {
		//RDD�� ����� ����ũ���� ����ϴ� �ֿ䰴ü�� ����ũ���ؽ�Ʈ�� �̿��� ������ �� �ִ�
		
		//��ü ���� conf
		//conf ��ü�� ���ؼ� set
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("RDDMain1");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		//JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5));
		
		List<String> list = new ArrayList<String>();
		list.add("a,b,c");
		list.add("d,e,f");
		list.add("g,h,i");
		
		JavaRDD<String> rdd = sc.parallelize(list); // input��, output��
		JavaRDD<String> rdd1 = rdd.flatMap(new FlatMapFunction<String, String>() {

			//Iterable => List, Map
			@Override
			public Iterator<String> call(String t) throws Exception {
				//arr[0] => a
				//arr[1] => b
				//arr[2] => c
				String[] arr = t.split(",");
				List<String> r = Arrays.asList(arr); // ����Ʈ ��ȯ
				return r.iterator();
			}
		});
		
		//lambda ���
		JavaRDD<String> rdd3 = rdd.flatMap((String t) -> Arrays.asList(t.split(",")).iterator());
		//output
		System.out.println(rdd3.collect());
		
/*
		//v1, ���ϰ�
		Function<Integer, Integer> f1 = new Function<Integer, Integer>(){
			
			@Override
			public Integer call(Integer v1) throws Exception {
				// TODO Auto-generated method stub
				return v1 + 1;
			}
		};
	   
	
		//rdd�� �ִ� ���� �ٸ� ������ �����ؼ� rdd1�� ����
		JavaRDD<Integer> rdd1 = rdd.map(f1);
		
		
		//����ؼ� 2,3,4,5,6 
		List<Integer> list1 = rdd1.collect();
		for(Integer r1: list1) { //Integer r1 : rdd1.collect()
			System.out.println(r1);
		}
		
		
		//1���� 50���� ���ڷ� ������ RDD�� �����ϰ�
		//2�� ����� rdd2��
		//3�� ����� rdd3��
		//5�� ����� rdd5��
		//��°�� : 0 2 0 4 0 ... 48 0 50
		List<Integer> list3 = new ArrayList<Integer>();
		for(int i = 1; i <= 50; i++) {
			list3.add(i);
		}
		
		//List to RDD
		JavaRDD<Integer> rdd50 = sc.parallelize(list3);
		
		JavaRDD<Integer> rdd31 = rdd50.flatMap(new FlatMapFunction<Integer, Integer>(){

			@Override
			public Iterable<Integer> call(Integer t) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
			
		}); 
		//���� �������θ� 
		//2�� ���
		JavaRDD<Integer> rdd2 = rdd50.map(new Function<Integer, Integer>() {
			@Override
				public Integer call(Integer v1) throws Exception {
					// TODO Auto-generated method stub
				if(v1 % 2 == 0 ) {
					return v1;					
				}
				return 0;
			}
		});
		for (Integer tmp: rdd3.collect()) {
			System.out.print(tmp + " ");
		}
		//3�� ���
		JavaRDD<Integer> rdd3 = rdd50.map(new Function<Integer, Integer>() {
			@Override
				public Integer call(Integer v1) throws Exception {
					// TODO Auto-generated method stub
				if(v1 % 3 == 0 ) {
					return v1;					
				}
				return 0;
			}
		});
		for (Integer tmp: rdd3.collect()) {
			System.out.print(tmp + " ");
		}

		//5�� ���
		JavaRDD<Integer> rdd5 = rdd50.map(new Function<Integer, Integer>() {
			@Override
				public Integer call(Integer v1) throws Exception {
					// TODO Auto-generated method stub
				if(v1 % 5 == 0 ) {
					return v1;					
				}
				return 0;
			}
		});
		for (Integer tmp: rdd5.collect()) {
			System.out.print(tmp + " ");
		}

		sc.close();
		//list�� �ִ� �ΰ��� ���
		//1
		List<String> list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		
		//2
		List<String> list = Arrays.asList("a","b","c");
		
		//LIST�� RDD�� ����
		JavaRDD<String> rdd = sc.parallelize(list);
		
		//RDD�� LIST�� ����
		List<String> list2 = rdd.collect();
		
		//list2�� ���� ����Ͻÿ�
		for(String str:list2) {
			System.out.println("list2:"+str);
		}
*/
	}
}
