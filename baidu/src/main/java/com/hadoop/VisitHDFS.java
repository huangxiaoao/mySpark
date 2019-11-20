package com.hadoop;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class VisitHDFS {

	public static void main(String[] args) throws Exception, URISyntaxException {
		//获取配置对象
		Configuration conf = new  Configuration();
		//加载用户自定义配置，要在项目上建立 src/main/resources/ha
		conf.addResource("/baidu/src/main/resources/core-site.xml");
		conf.addResource("/baidu/src/main/resources/hdfs-site.xml");

		//获取文件系统对象
		FileSystem fileSystem = FileSystem.newInstance(new URI("/"), conf);
		
		//展示里面所有的目录
		FileStatus[] listStatus = fileSystem.listStatus(new Path("/"));
		
		for (FileStatus fileStatus : listStatus) {
			System.out.println(fileStatus);
		}

		//添加文件
		
	
	
	}
}
