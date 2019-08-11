package com.java;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;


public class ListHDFS {

	public static void main(String[] args) {
		
		try {
			Configuration conf = new Configuration();
			Path dirPath = new Path("hdfs://175.126.73.18:9000/test2/");
			FileSystem fs = dirPath.getFileSystem(conf);
			
			//디렉토리내의 파일 목록
			RemoteIterator<LocatedFileStatus> iter = fs.listFiles(dirPath, true);
			
			//반복자 패턴
			while(iter.hasNext()) {
				LocatedFileStatus lfs = iter.next();
				System.out.println(lfs.getPath());
			}
			fs.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
		
		
	}

}
