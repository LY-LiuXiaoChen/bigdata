package com.cj.mapreduce.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * keyin,map阶段输入的key的类型：LongWritable
 * valuein,map阶段输入的value类型：Text
 * keyout,map阶段输出的key类型：Text
 * valueout,map阶段输出的value类型：IntWritable
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private Text keyOut = new Text();
    private IntWritable valueOut = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        //获取一行
        String lineString = value.toString();
        //分隔符分割
        String[] words = lineString.split(" ");
        //循环写出
        for (String word : words) {
            keyOut.set(word);
            context.write(keyOut, valueOut);
        }
    }
}
