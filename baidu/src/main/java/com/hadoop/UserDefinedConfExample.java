package com.hadoop;

import org.apache.hadoop.conf.Configuration;

public class UserDefinedConfExample {
	public static void main(String[] args) {
		serConf();
		getConf();
	}

	private static void serConf() {
		Configuration conf = new Configuration();
		conf.addResource("core-site.xml");
		conf.set("fs.defaultFS", "huangxiaoao");
		System.err.println(conf.get("fs.defaultFS"));
	}

	private static void  getConf() {
		Configuration conf = new Configuration();
		String defaults = conf.get("fs.defaultFS");
		System.out.println(defaults);
	
	}
}
