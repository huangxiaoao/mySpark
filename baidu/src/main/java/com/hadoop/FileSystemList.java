package com.hadoop;

import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class FileSystemList {
	public static void main(String[] args) throws Exception {
		//建立与hdfs的URL
		URI uri = new URI("hdfs://huang001:9000");
		//获取配置参数
		Configuration conf = new Configuration();
		//获取文件系统
		FileSystem fileSystem = FileSystem.get(uri, conf);
		
		FileStatus[] listStatus = fileSystem.listStatus(new Path("/"));
		
		for (FileStatus fileStatus : listStatus) {
			//列出hdfs上述目录的所有文件及其信息
			System.out.println(fileStatus);
			//判断目录下是否是文件 , 如果是再遍历
			if(fileStatus.isFile()) {
				
				BlockLocation[] fileBlockLocations = fileSystem.getFileBlockLocations(fileStatus, 0,fileStatus.getLen() );
				for (BlockLocation fileStatus2 : fileBlockLocations) {
					System.err.println(fileStatus2);
				}
			}
			
			
			
		}
		
	}
}
