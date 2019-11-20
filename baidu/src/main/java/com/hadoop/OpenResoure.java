package com.hadoop;

import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

/**
 * 
 * @author haungxiaoao
 *读取所设置的路径中文件的内容
 */
public class OpenResoure {
	public static void main(String[] args) throws Exception {
		// 建立与hdfs的URL
		URI uri = new URI("hdfs://huang001:9000");
		// 获取配置参数
		Configuration conf = new Configuration();
		// 获取文件系统
		FileSystem fileSystem = FileSystem.get(uri, conf);
		//获取配置路径
		Path f = new Path("/put/a.txt");
		//获取Hadoop专用输入通道
		FSDataInputStream fsIs = fileSystem.open(f);
		
		//用Hadoop自带工具把写的对象输出到控制台
		IOUtils.copyBytes(fsIs, System.out, 1024, true);
	}
}
