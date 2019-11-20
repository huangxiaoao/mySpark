package com.baidu;

import java.net.URI;

import javax.servlet.http.HttpSession;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class CreatFile {
	public static void main(String[] args) throws Exception {
		//3.使用java api往aaa里面上传文件a.txt（10分）
		
		//链接Hadoop 
		URI uri = new URI("hdfs://huang001:9000");
		//加载配置文件
		Configuration conf = new Configuration();
		
		//获取文件系统
		FileSystem fileSystem = FileSystem.get(uri, conf);
		
		Path src = new Path("D:\\eclipse2019workspace\\com.baidu\\src\\main\\resources\\a.txt");
		Path dst = new Path("/aaa");
		fileSystem.copyFromLocalFile(src, dst );
		
		
	}
}
