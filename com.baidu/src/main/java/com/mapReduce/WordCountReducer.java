package com.mapReduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * reduce过程
 * 
 * reduce端接收的是map的输出，即4个<k2,v2>，3个分组。
 * 在reduce执行之前，reduce端合并、排序、分组<k2,v2>。
 * 在reduce()调用之前，有3个分组，即<hello,{1,1}><me,{1}><you,{1}>
 * 一次reduce()执行，处理1个分组。所以说，执行3次reduce()。
 * ------------------------------------------------------------------
 * reduce task执行结束后，框架会把reduce输出的<k3,v3>写入到HDFS中。
 * @author 黄小澳
 *
 */
public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
	
	//k3 表示当前不同的单词  , 与k2 含义相同
	LongWritable v3 = new LongWritable();
	
	/**
	 * k2表示每个不同的单词
	 * v2s表示每个不同的单词的出现次数
	 * 在reduce()中，只需要汇总v2s中的出现次数就行。
	 */
	
	@Override
	protected void reduce(Text k2, Iterable<LongWritable> v2s,
			Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {
		// sum 表示当前单词K2 出现的总次数
		Long sum = 0L;
		for (LongWritable v2 : v2s) {
			sum += v2.get();
		}
		
		//k3 表示当前不同的单词 , 与k2含义相同
		v3.set(sum);
		context.write(k2, v3);
	
	
	}
	
	
}
