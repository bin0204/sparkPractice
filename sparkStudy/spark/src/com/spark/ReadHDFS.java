package com.spark;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.log4j.BasicConfigurator;


public class ReadHDFS {
	//실시간으로 데이터를 수집하는 시스템을 자바로 구축
	//JSOUP 크롤링
	public static void main(String[] args) {
		try {
			
			Configuration config = new Configuration();
			
			//hdfs에 쓰기
			Path hdfs = new Path("hdfs://175.126.73.18:9870/test/a_bin.txt");
			FileSystem fs = hdfs.getFileSystem(config);
			FSDataOutputStream fdo = fs.create(hdfs);
			fdo.writeUTF("hello java");
			fdo.close();

			//hdfs에 읽기
			Path hdfs1 = new Path("hdfs://175.126.73.18:9000/test1/a.txt");
			FileSystem fs1 = hdfs1.getFileSystem(config);
			FSDataInputStream fdi = fs1.open(hdfs1);
			String str = fdi.readUTF();
			System.out.println(str);
			fdi.close();
			
		} 
		catch(Exception e) {
			
		}
	}

}
