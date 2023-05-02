package com.cj.mapreduce.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * keyin,reduce阶段输入的key的类型：Text
 * valuein,reduce阶段输入的value类型：IntWritable
 * keyout,reduce阶段输出的key类型：Text
 * valueout,reduce阶段输出的value类型：IntWritable
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private IntWritable valueOut = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        int sum = 0;
        //累加value的值
        for (IntWritable value : values) {
            sum += value.get();
        }
        //写出
        valueOut.set(sum);
        context.write(key, valueOut);
    }
}

