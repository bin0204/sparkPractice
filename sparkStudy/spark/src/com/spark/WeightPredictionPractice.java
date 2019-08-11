package com.spark;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.ml.evaluation.RegressionEvaluator;
import org.apache.spark.ml.feature.StringIndexer;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.regression.LinearRegressionModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class WeightPredictionPractice {

	public static void main(String[] args) {

		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("WeightPredictionPractice");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext spark = new SQLContext(sc);
		HiveContext spark1 = new HiveContext(sc);
		
		JavaRDD<String> rdd = sc.textFile("hdfs://175.126.73.18:9000/test2/regression.csv");
		
		//2. header 없애기
		JavaRDD<String> rdd1 = rdd.filter(new Function<String, Boolean>(){
			@Override
			public Boolean call(String v1) throws Exception {
				//utf8 bom 제거
				if (v1.startsWith("\uFEFF")) {
					v1 = v1.substring(1);
				}
				if(v1.startsWith("age")) {
					return false;
				}
				return true;
			}
		});
		
		//3. split to Row 생성
		JavaRDD<Row> rdd2 = rdd1.map(new Function<String, Row>(){
			@Override
			public Row call(String v1) throws Exception {
				String[] arr = v1.split(",");
				return RowFactory.create(
						arr[0], 
						Double.parseDouble(arr[1]), 
						Double.parseDouble(arr[2])
				);
			}
		});
		
		//3. 스키마 만들기
		StructField sf1 = DataTypes.createStructField("age", DataTypes.StringType, true);
		StructField sf2 = DataTypes.createStructField("height", DataTypes.DoubleType, true);
		StructField sf3 = DataTypes.createStructField("weight", DataTypes.DoubleType, true);


		//데이터 프레임 생성
		StructType schema = DataTypes.createStructType(Arrays.asList(sf1,sf2,sf3));
		Dataset<Row> df1 = spark.createDataFrame(rdd2, schema);
		df1.show(false);
		
		spark1.registerDataFrameAsTable(df1, "df1"); //테이블 생성
		//Convert 세를 개월 수로 변경
		//height -> height를 double형으로 변경
		StringIndexer si = new StringIndexer().setInputCol("height").setOutputCol("heightCode");
		Dataset<Row> df2 = si.fit(df1).transform(df1);
		//df51.show(50,false);
		
		//age -> ageCode를 double형으로 변경
		StringIndexer si1 = new StringIndexer().setInputCol("age").setOutputCol("ageCode");
		Dataset<Row> df3 = si1.fit(df2).transform(df2);
		//df52.show(50, false);
		
		//1. Vector로 변환 height, age 
		VectorAssembler assembler = new VectorAssembler();
		assembler.setInputCols(new String[] {"ageCode","heightCode"});
		assembler.setOutputCol("features");
		Dataset<Row> df4 = assembler.transform(df3);
		df4.show(50,false);
		
		//몸무게 예측
		
		//트레이닝 데이터, 테스트 데이터 분할
		Dataset<Row> dataArr [] = df4.randomSplit(new double[] {0.7, 0.3});
		
		Dataset<Row> training = dataArr[0];
		
		Dataset<Row> test = dataArr[1];
		
		//선형회귀
		LinearRegression lr = new LinearRegression();
		lr.setMaxIter(5); //set the maximum number of iterations
		lr.setRegParam(0.3); //set the regularization parameter
		lr.setLabelCol("weight");
		lr.setFeaturesCol("features");
		
		//모델 생성
		LinearRegressionModel lrm = lr.fit(training);
		
		//모델에서 결정 계수
		System.out.println(lrm.summary().r2());
		
		Dataset<Row> df54 = lrm.setPredictionCol("predict_weight").transform(test);
		df54.show(false);
		
		//모델 평가
		RegressionEvaluator evaluator = new RegressionEvaluator();
		evaluator.setLabelCol("weight").setPredictionCol("predict_weight");
		df54.select("year","height","weight","predict_weight").show();
		
		//root mean square error
		//편차 제곱의 평균에 루트: 낮은 게 좋음
		double rmse = evaluator.evaluate(df54);

		double mse = evaluator.setMetricName("mse").evaluate(df54);
		
		//coefficient of determination => 결정계수
		//결정계수 1에 가까울 수록 데이터를 잘 설명한다고 봄
		double r2 = evaluator.setMetricName("r2").evaluate(df54);
		double mae = evaluator.setMetricName("mae").evaluate(df54);
	
		System.out.println("r2: " + r2);
		System.out.println("rmse: " + rmse);
		System.out.println("mse: " + mse);
		System.out.println("mae: " + mae);
				
				
	}

}
