package com.cj.mapreduce.partitioner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowBeanMapper extends Mapper <LongWritable,Text,Text, FlowBean>{
    private Text outKey=new Text();
    private FlowBean outValue=new FlowBean();
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FlowBean>.Context context) throws IOException, InterruptedException {
        //获取一行
        String line = value.toString();
        //分割
        String[] split = line.split("\t");
        String phone=split[1];
        String up = split[split.length - 3];
        String down = split[split.length - 2];

        //封装outKey对象
        outKey.set(phone);
        //封装outValue对象
        outValue.setUpFlow(Long.parseLong(up));
        outValue.setDownFlow(Long.parseLong(down));
        outValue.setTotalFlow();

        //写出
        context.write(outKey,outValue);
    }
}
