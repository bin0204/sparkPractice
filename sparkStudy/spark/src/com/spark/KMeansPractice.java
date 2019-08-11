package com.spark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.ml.Pipeline;
import org.apache.spark.ml.PipelineModel;
import org.apache.spark.ml.PipelineStage;
import org.apache.spark.ml.clustering.KMeans;
import org.apache.spark.ml.evaluation.RegressionEvaluator;
import org.apache.spark.ml.feature.StringIndexer;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.regression.LinearRegressionModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext; //hive-site.xml
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class KMeansPractice {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("KMeansPractice");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext spark = new SQLContext(sc);
		HiveContext spark1 = new HiveContext(sc);
		
		JavaRDD<String> rdd = sc.textFile("hdfs://175.126.73.18:9000/test2/k_means1.csv");
		


		JavaRDD<String> rdd1 = rdd.filter(new Function<String, Boolean>() {
			@Override
			public Boolean call(String v1) throws Exception {
				if (v1.startsWith("\uFEFF")) {
					v1 = v1.substring(1);
					return false;
				}
				if (v1.startsWith("번호")) {
					return false;
				}
				return true;
			}
		});
		
		JavaRDD<Row> rdd2 = rdd1.map(new Function<String, Row>() {
			@Override
			public Row call(String v1) throws Exception {
				String[] arr = v1.split(",");
				return RowFactory.create(
						arr[0].replace("\"", ""), arr[1].replace("\"", ""), arr[2].replace("\"", ""),
						arr[3].replace("\"", ""), arr[4].replace("\"", ""),
						Double.parseDouble(arr[5].replace("\"", "")), Double.parseDouble(arr[6].replace("\"", ""))
						);
			}
		});

	
		//번호	명칭	행정시	행정구	행정동	WGS84 X 좌표정보	WGS84 Y 좌표정보
		List<StructField> fields = new ArrayList<StructField>();
		fields.add(DataTypes.createStructField("no", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("name", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("loc1", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("loc2", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("loc3", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("X", DataTypes.DoubleType, true));
		fields.add(DataTypes.createStructField("Y", DataTypes.DoubleType, true));
		
		StructType schema = DataTypes.createStructType(fields);
		
		Dataset<Row> df = spark1.createDataFrame(rdd2, schema);

		spark1.registerDataFrameAsTable(df, "df");

		Dataset<Row> df1 = spark1.sql("SELECT loc2, X, Y FROM df ");
		
		//1. String을 Code값으로 변경
		StringIndexer si = new StringIndexer().setInputCol("loc2").setOutputCol("loccode");
		Dataset<Row> df2 = si.fit(df1).transform(df1);
		
		//2. features vector
		VectorAssembler assembler = new VectorAssembler();
		assembler.setInputCols(new String[] {"loccode","X","Y"});
		assembler.setOutputCol("features");
		
		//3. k평균
		KMeans kmean = new KMeans();
		kmean.setK(5);
		kmean.setFeaturesCol("features");
		
	
		//4. pipeline 설정 
		Pipeline pipeline = new Pipeline();
		pipeline.setStages(new PipelineStage [] {si, assembler, kmean});

		//5. pipelineModel 생성
		PipelineModel pm = pipeline.fit(df1);
		
		//6. 모델을 이용하여 DF생성
		Dataset<Row> df3 = pm.transform(df1);
		df3.show(50, false);
		
		//7.hdfs 저장하기
		df3.repartition(1).write().json("hdfs://175.126.73.18:9000/test2/bin");

	}

}
