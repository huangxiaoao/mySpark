package com.hadoop;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class SimpleLineReaderExample {
	public static void main(String[] args) throws Exception {
		// 定义回车符
		byte BR = '\r';
		// 定义换行符
		byte LN = '\n';

		// 获取hdfs链接地址
		URI uri = new URI("hdfs://huang001:9000");
		//获取hdfs默认配置参数
		Configuration conf = new Configuration();
		
		//获取hdfs文件系统
		FileSystem fileSystem = FileSystem.get(uri, conf);
		
		//获取操作指定内容的输入流
		FSDataInputStream fsis = fileSystem.open(new Path("/hellow"));
		
		//创建一个缓冲数组,用来读取流中的字节
		byte[] buffer = new byte[1024 * 64];
		//读取流中的字节到缓冲的数组中,length中表示读取字节长度,不表示数组的长度
		int length = fsis.read(buffer);
		//offset是偏移量,表示开始的位置
		int offset = 0;
		//pos表示当前位置
		int pos = 0;
		for (; pos < length; pos++) {
			/*System.out.println(buffer[pos]);*/
			//判断缓冲数组中的字节是否是BR或者LN,如果是true,则表示遇到回车换行
			if (buffer[pos] == BR || buffer[pos] == LN) {
				//读取LN或者BR内容,表示一行
				String line = new String(buffer, offset, pos);
				//打印输出
				System.out.println(line);
				//跳出BR或者LN
				pos++;
				//下一次读取一行的时候,设置新的位置
				offset = pos;
			}
		}
		//关闭输入流
		fsis.close();
	
	}
}
