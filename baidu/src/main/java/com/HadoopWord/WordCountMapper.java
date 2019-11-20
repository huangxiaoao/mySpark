package com.HadoopWord;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text,LongWritable> {
	// 设置全局变量
	Text k2 = new Text();
	LongWritable v2 = new LongWritable();
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {


		/**
		 * 前面已经有拆分完成的<k1,v1>。调用map()一次方法，就处理一个<k1,v1>对。
		 * 
		 * 在map()方法，拆分每一行，得到每个单词，每个单词(不是每个不同的单词)的出现次数是1。
		 * 构造<k2,v2>，k2表示单词，v2表示出现次数1。
		 */

		// 因为要对每行内容做拆分，需要调用String.split()，所以需要把Text转行成String。
		String line = value.toString();
		// 拆分每行内容，结果是单词的数组
		String[] split = line.split("\t");
		// 循环数组，取每个单词。在for循环中构造<k2,v2>
		for (String word : split) {
			k2.set(word);
			v2.set(1L);
			// 把<k2,v2>写出去，相当于调用return语句
			context.write(k2, v2);
		}
	
	}
	
}
