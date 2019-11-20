package com.hadoop;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class CreateHdfsFile {
	public static void main(String[] args) throws Exception {

		// 建立与hdfs的URL
		URI uri = new URI("hdfs://huang001:9000");
		// 获取配置参数
		Configuration conf = new Configuration();
		// 获取文件系统
		FileSystem fileSystem = FileSystem.get(uri, conf);
		
	//	fileSystem.delete(new Path("/core-site.xml"));
		/*
		fileSystem.mkdirs(new Path("/abcd"));
		
		Path src = new Path("D:\\eclipse2019workspace\\baidu\\src\\main\\resources\\core-site.xml");
		Path dst = new Path("/abcd");
		
		fileSystem.copyFromLocalFile(src, dst);
		*/
		
		// 上传的
		FSDataOutputStream out = fileSystem.create(new Path("/aaa"));
		// 输入本地文件的路径
		String file = "D:\\eclipse2019workspace\\baidu\\src\\main\\resources\\core-site.xml";
		FileInputStream in = new FileInputStream(file);
		// 调用工具
		IOUtils.copyBytes(in, out, 1024, true);
	}
}
