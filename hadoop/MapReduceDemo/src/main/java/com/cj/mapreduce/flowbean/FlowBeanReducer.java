package com.cj.mapreduce.flowbean;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowBeanReducer extends Reducer<Text,FlowBean,Text,FlowBean> {
   private FlowBean outValue=new FlowBean();
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Reducer<Text, FlowBean, Text, FlowBean>.Context context) throws IOException, InterruptedException {
        //循环
        long upFlow=0;
        long downFlow=0;
        for (FlowBean value : values) {
            upFlow+=value.getUpFlow();
            downFlow+=value.getDownFlow();
        }

        //封装outValue对象
        outValue.setUpFlow(upFlow);
        outValue.setDownFlow(downFlow);
        outValue.setTotalFlow();

        //写出
        context.write(key,outValue);
    }
}
