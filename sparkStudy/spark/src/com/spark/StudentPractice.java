package com.spark;

import static org.apache.spark.sql.functions.col;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import static org.apache.spark.sql.functions.lit;
public class StudentPractice {
	public static void main(String[] args) {
		
		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("StudentPractice");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext spark = new SQLContext(sc);
		HiveContext spark1 = new HiveContext(sc);
		
		JavaRDD<String> rdd = sc.textFile("hdfs://175.126.73.18:9000/test2/Report.csv");

//		JavaRDD<String> rdd1 = rdd.filter(new Function<String, Boolean>() {
//			@Override
//			public Boolean call(String v1) throws Exception {
//				if(v1.contains("기간")) {
//					return false;
//				}
//				return true;	
//			}
//		});
//		
//		//System.out.println(rdd1.collect());
//		
//		
//		JavaRDD<StudentData> rdd2 = rdd1.map(new Function<String, StudentData>() {
//			@Override
//			public StudentData call(String v1) throws Exception {
//				String arr [] = v1.split(",");
//				return new StudentData(
//						arr[0], //year
//						arr[1], //div ---should be removed
//						Double.parseDouble(arr[2]), // maEleHeight
//						Double.parseDouble(arr[3]), // feEleHeight
//						Double.parseDouble(arr[4]),
//						Double.parseDouble(arr[5]),
//						Double.parseDouble(arr[6]),
//						Double.parseDouble(arr[7]),
//						Double.parseDouble(arr[8]), 
//						Double.parseDouble(arr[9]),
//						Double.parseDouble(arr[10]),
//						Double.parseDouble(arr[11]),
//						Double.parseDouble(arr[12]),
//						Double.parseDouble(arr[13]));
//				}
//	    });
//		DataFrame df = spark.createDataFrame(rdd2, StudentData.class);
//		//df.printSchema();
//		//df.show();
//		
//		
//	
//		//remove the divColumn
//		DataFrame df2 = df.drop("div");
//		//df2.show();
//		
//		spark1.registerDataFrameAsTable(df2, "df");
//		
//		DataFrame maEle = spark1.sql("SELECT year, maEleHeight AS height, maEleWeight AS weight, 'elementary' grade, 'male' gender FROM df");
//		DataFrame feEle = spark1.sql("SELECT year, feEleHeight AS height, feEleWeight AS weight, 'elementary' grade, 'female' gender FROM df");
//		DataFrame maMid = spark1.sql("SELECT year, maMidHeight AS height, maMidWeight AS weight, 'elementary' grade, 'male' gender FROM df");
//		DataFrame feMid = spark1.sql("SELECT year, feMidHeight AS height, feMidWeight AS weight, 'elementary' grade, 'female' gender FROM df");
//		DataFrame maHigh = spark1.sql("SELECT year, maHighHeight AS height, maHighWeight AS weight, 'elementary' grade, 'male' gender FROM df");
//		DataFrame feHigh = spark1.sql("SELECT year, maHighHeight AS height, feHighWeight AS weight, 'elementary' grade, 'female' gender FROM df");
//		
//		//UNION ALL
//		DataFrame dfFinal = maEle.unionAll(feEle).unionAll(maMid).unionAll(feMid).unionAll(maHigh).unionAll(feHigh);
//		dfFinal.show(100, false);
		
		
		
		//2. header 없애기
		JavaRDD<String> rdd1 = rdd.filter(new Function<String, Boolean>(){
			@Override
			public Boolean call(String v1) throws Exception {
				//utf8 bom 제거
				if (v1.startsWith("\uFEFF")) {
					v1 = v1.substring(1);
				}
				if(v1.startsWith("기간")) {
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
						Integer.parseInt(arr[0]), 
						arr[1], 
						Double.parseDouble(arr[2]),
						Double.parseDouble(arr[3]),
						Double.parseDouble(arr[4]),
						Double.parseDouble(arr[5]),
						Double.parseDouble(arr[6]),
						Double.parseDouble(arr[7]),
						Double.parseDouble(arr[8]),
						Double.parseDouble(arr[9]),
						Double.parseDouble(arr[10]),
						Double.parseDouble(arr[11]),
						Double.parseDouble(arr[12]),
						Double.parseDouble(arr[13])
				);
			}
		});
		
		//3. 스키마 만들기
		StructField sf1 = DataTypes.createStructField("c1", DataTypes.IntegerType, true);
		StructField sf2 = DataTypes.createStructField("c2", DataTypes.StringType, true);
		StructField sf3 = DataTypes.createStructField("c3", DataTypes.DoubleType, true);
		StructField sf4 = DataTypes.createStructField("c4", DataTypes.DoubleType, true);
		StructField sf5 = DataTypes.createStructField("c5", DataTypes.DoubleType, true);
		StructField sf6 = DataTypes.createStructField("c6", DataTypes.DoubleType, true);
		StructField sf7 = DataTypes.createStructField("c7", DataTypes.DoubleType, true);
		StructField sf8 = DataTypes.createStructField("c8", DataTypes.DoubleType, true);
		StructField sf9 = DataTypes.createStructField("c9", DataTypes.DoubleType, true);
		StructField sf10 = DataTypes.createStructField("c10", DataTypes.DoubleType, true);
		StructField sf11 = DataTypes.createStructField("c11", DataTypes.DoubleType, true);
		StructField sf12 = DataTypes.createStructField("c12", DataTypes.DoubleType, true);
		StructField sf13 = DataTypes.createStructField("c13", DataTypes.DoubleType, true);
		StructField sf14 = DataTypes.createStructField("c14", DataTypes.DoubleType, true);
		
		//데이터 프레임 생성
		StructType schema = DataTypes.createStructType(Arrays.asList(sf1,sf2,sf3,sf4,sf5,sf6,sf7,sf8,sf9,sf10,sf11,sf12,sf13,sf14));
		Dataset<Row> df1 = spark.createDataFrame(rdd2, schema);
		df1.show(false);
		
		/*
		//초등학교 남학생 정보
		//import static org.apache.spark.sql.functions.col;
		//import static org.apache.spark.sql.functions.lit;
		DataFrame df2 = df1.select(col("c1").as("year"), col("c3").as("height"), col("c5").as("weight"))
					.withColumn("grade", lit("elementary")).withColumn("gender", lit("min"));
		df2.show(false);
		*/
		
		//HIVE
		spark1.registerDataFrameAsTable(df1, "df1"); //테이블 생성
		Dataset<Row> df22 = spark1.sql("SELECT	c1 year, c3 height,	c5 weight, 'elementary' grade, 'man' gender FROM df1");
		Dataset<Row> df23 = spark1.sql("SELECT	c1 year, c4 height,	c6 weight, 'elementary' grade, 'women' gender FROM df1");
		Dataset<Row> df24 = spark1.sql("SELECT	c1 year, c7 height,	c9 weight, 'middle' grade, 'man' gender FROM df1");
		Dataset<Row> df25 = spark1.sql("SELECT	c1 year, c8 height,	c10 weight, 'middle' grade, 'women' gender FROM df1");
		Dataset<Row> df26 = spark1.sql("SELECT	c1 year, c11 height, c13 weight, 'high' grade, 'man' gender FROM df1");
		Dataset<Row> df27 = spark1.sql("SELECT	c1 year, c12 height, c14 weight, 'high' grade, 'women' gender FROM df1");
		Dataset<Row> df50 = df22.unionAll(df23).unionAll(df24).unionAll(df25).unionAll(df26).unionAll(df27);
		
		df50.show(100, false);		

		//grade -> gradecode를 double형으로 변경
		StringIndexer si = new StringIndexer().setInputCol("grade").setOutputCol("gradeCode");
		Dataset<Row> df51 = si.fit(df50).transform(df50);
		//df51.show(50,false);
		
		//gender -> gendercode를 double형으로 변경
		StringIndexer si1 = new StringIndexer().setInputCol("gender").setOutputCol("genderCode");
		Dataset<Row> df52 = si1.fit(df51).transform(df51);
		//df52.show(50, false);
		
		//1. Vector로 변환 키, 학년, 성별 
		VectorAssembler assembler = new VectorAssembler();
		assembler.setInputCols(new String[] {"height","gradeCode","genderCode"});
		assembler.setOutputCol("features");
		Dataset<Row> df53 = assembler.transform(df52);
		df53.show(50,false);
		
		
		//트레이닝 데이터, 테스트 데이터 분할
		Dataset<Row> dataArr [] = df53.randomSplit(new double[] {0.7, 0.3});
		
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
		
		
		
		/******************************Different way**********************************/
		
		
		//Create eleDFMale
//		DataFrame maEleDFFinal = df2.select(col("year"),col("maEleHeight"),col("maEleWeight"))
//									.withColumn("grade",lit("elementary"))
//									.withColumn("gender", lit("male"))
//									.withColumnRenamed("maEleHeight", "height")
//									.withColumnRenamed("maEleWeight", "weight");;
//
//		//maEleDFFinal.show();
//
//		//Create eleDFFemale
//		DataFrame feEleDFFinal = df2.select(col("year"),col("feEleHeight"),col("feEleWeight"))
//									.withColumn("grade",lit("elementary"))
//									.withColumn("gender", lit("female"))
//									.withColumnRenamed("feEleHeight", "height")
//									.withColumnRenamed("feEleWeight", "weight");;
//		//feEleDFFinal.show();
//	
//
//		//Create eleDFMale
//		DataFrame maMidDFFinal = df2.select(col("year"),col("maMidHeight"),col("maMidWeight"))
//									.withColumn("grade",lit("middle"))
//									.withColumn("gender", lit("male"))
//									.withColumnRenamed("maMidHeight", "height")
//									.withColumnRenamed("maMidWeight", "weight");
//		//maMidDFFinal.show();
//
//		//Create eleDFFemale
//		DataFrame feMidDFFinal = df2.select(col("year"),col("feMidHeight"),col("feMidWeight"))
//									.withColumn("grade",lit("middle"))
//									.withColumn("gender", lit("female"))
//									.withColumnRenamed("feMidHeight", "height")
//									.withColumnRenamed("feMidWeight", "weight");
//		//feMidDFFinal.show();
//		
//		//Create eleDFMale
//		DataFrame maHighDFFinal = df2.select(col("year"),col("maHighHeight"),col("maHighWeight"))
//									.withColumn("grade",lit("high"))
//									.withColumn("gender", lit("male"))
//									.withColumnRenamed("maHighHeight", "height")
//									.withColumnRenamed("maHighWeight", "weight");
//		//maHighDFFinal.show();
//
//		//Create eleDFFemale
//		DataFrame feHighDFFinal = df2.select(col("year"),col("feHighHeight"),col("feHighWeight"))
//									.withColumn("grade",lit("high"))
//									.withColumn("gender", lit("female"))
//									.withColumnRenamed("feHighHeight", "height")
//									.withColumnRenamed("feHighWeight", "weight");
//		//feHighDFFinal.show();
//		
//
//		//final DatFrame for all students
//		DataFrame eleMidHigh = maEleDFFinal.unionAll(feEleDFFinal).unionAll(feMidDFFinal).unionAll(feHighDFFinal);
//		//eleMidHigh.show(100,false);
		
		
	}
}
