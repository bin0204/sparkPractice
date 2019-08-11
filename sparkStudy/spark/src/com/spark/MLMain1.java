package com.spark;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.Pipeline;
import org.apache.spark.ml.PipelineModel;
import org.apache.spark.ml.PipelineStage;
import org.apache.spark.ml.classification.LogisticRegression;
import org.apache.spark.ml.classification.LogisticRegressionModel;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class MLMain1 {

	public static void main(String[] args) throws IOException {
		SparkConf conf = new SparkConf()
				.setMaster("local[*]")
				.setAppName("MLMain1");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext spark = new SQLContext(sc);
		
		List<Person1> p1 = Arrays.asList(
			new Person1(161.0, 69.87, 29, 0.0),
			new Person1(176.78, 74.35, 34, 1.0),
			new Person1(159.23, 58.32, 29, 0.0)
		);
		Dataset<Row> df1 = spark.createDataFrame(p1, Person1.class);
		
		List<Person1> p2 = Arrays.asList(
				new Person1(161.0, 69.87, 29, 0.0),
				new Person1(176.78, 74.35, 34, 0.0),
				new Person1(159.23, 58.32, 29, 0.0)
		);
		Dataset<Row> df3 = spark.createDataFrame(p2, Person1.class);		
		
		
		//1. Vector로 변환 키, 몸무게, 나이를 
		VectorAssembler assembler = new VectorAssembler();
		assembler.setInputCols(new String[] {"height","weight","age"});
		assembler.setOutputCol("features");
		
//		DataFrame df2 = assembler.transform(df1);
//		df2.show();
		
//		DataFrame df4 = assembler.transform(df3);
		
//		df4.show();
		//2. 로지스틱 회귀 설정
		LogisticRegression lr = new LogisticRegression();
		lr.setMaxIter(10).setRegParam(0.01);
		
		//4. pipeline 설정 
		Pipeline pipeline = new Pipeline();
		pipeline.setStages(new PipelineStage [] {assembler, lr});

		//5. pipelineModel 생성
		PipelineModel pm = pipeline.fit(df1);
		
		//6. 모델을 이용하여 DF생성
		Dataset<Row> df2 = pm.transform(df1);
		df2.show(50, false);
		
		//3. 모델생성
//		LogisticRegressionModel lrm = lr.fit(df2);
//		LogisticRegressionModel lrmm = lr.fit(df4);
		
		//모델저장
		//lrm.write().overwrite().save("저장위치");
		
		//모델불러오기
		//LogisticRegressionModel lrm 
		//	= LogisticRegressionModel.load("저장위치");  
		
		
		//4. 예측값 확인  => df3
//		lrm.transform(df2).show();
//		lrmm.transform(df4).show();
	}
}
