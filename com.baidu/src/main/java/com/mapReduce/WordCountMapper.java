package com.mapReduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * map过程。 在这里，程序员继承Mapper，覆盖map(...)方法。 该类在运行的时候，称作map task，是一个java进程。
 * ----------------------------------------------------
 * map()全部执行完后，产生的<k2,v2>有4个，即<hello,1><you,1><hello,1><me,1>。
 * 排序后是<hello,1><hello,1><me,1><you,1>。 分组后是<hello,{1,1}><me,{1}><you,{1}>。
 * 
 * @author 黄小澳
 *
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
	//设置全局变量
	Text k2 = new Text();
	LongWritable v2 = new LongWritable();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		/*
		 * 早map方法中 ,拆分每一行,得到每个单词,每个单词(	都是不同的单词,)的出现次数是1;
		 * 构造<K2,V2>   , k2表示单词,V2表示出现的次数
		 */
		//因为要对每行内容做拆分,需要调用String.split(),所以需要把Text转行成string
		String line = value.toString();
		// 拆分每行的内容,结果是单词的数组
		String[] split = line.split("\t");
		//循环每一个数组 , 取每一个单词,在for循环中构造<K2,V2>
		for (String word : split) {
			k2.set(word);
			v2.set(1L);
			//把<K2,V2>写出去,相当于return语句
			context.write(k2, v2);
		}
	
	
	}
}
