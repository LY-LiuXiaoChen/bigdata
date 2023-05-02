package com.cj.mapreduce.writablecomparable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowBeanMapper extends Mapper<LongWritable, Text, FlowBean, Text> {
    private FlowBean outKey = new FlowBean();
    private Text outValue=new Text();
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, FlowBean, Text>.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split("\t");

        outKey.setUpFlow(Long.parseLong(split[1]));
        outKey.setDownFlow(Long.parseLong(split[2]));
        outKey.setTotalFlow();
        outValue.set(split[0]);
        context.write(outKey,outValue);
    }
}
