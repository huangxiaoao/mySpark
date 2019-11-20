package com.hadoop;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

public class FileSystemExample {
	public static void main(String[] args) throws Exception {
		
		URI uri = new URI("hdfs://huang001:9000");
		
		Configuration conf = new Configuration();
		FileSystem fileSystem = FileSystem.get(uri, conf);
		System.out.println(fileSystem);
		
		
		
		
	}
}
