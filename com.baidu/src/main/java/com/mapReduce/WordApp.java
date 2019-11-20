package com.mapReduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WordApp {
	public static void main(String[] args) throws Exception {
		// 输入路径
		String inputPaths = args[0];
		// 输出路径
		Path outPutDir = new Path(args[1]);
		// 加载Hadoop环境的配置
		Configuration conf = new Configuration();
		// 得到当前的执行程序的名字
		String jobName = WordApp.class.getSimpleName();

		// 实例化Job
		Job job = Job.getInstance(conf, jobName);
		// 打成jar包
		job.setJarByClass(WordApp.class);

		// 设置输入路径
		FileInputFormat.setInputPaths(job, inputPaths);

		// 设置输出路径
		FileOutputFormat.setOutputPath(job, outPutDir);

		// 自定义Mapper
		job.setMapperClass(WordCountMapper.class);
		// 指定k2,v2
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);

		// 自定义Reducer类
		job.setReducerClass(WordCountReducer.class);
		// 指定K3 ,V3
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);

		job.waitForCompletion(true);

	}
}
