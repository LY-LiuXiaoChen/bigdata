package com.cj.mapreduce.writablecomparable;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FlowBeanDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        //获取job
        Configuration configuration = new Configuration();
        Job job = new Job(configuration);

        //设置 jar 路径
        job.setJarByClass(FlowBeanDriver.class);
        //关联mapper和reducer
        job.setMapperClass(FlowBeanMapper.class);
        job.setReducerClass(FlowBeanReducer.class);
        //设置map输出类型
        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(Text.class);
        //设置最终输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);
        //设置输入路径和输出路径
        FileInputFormat.setInputPaths(job,new Path("D:\\testoutput\\phoneoutput"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\testoutput\\phoneoutput4"));
        //提交job
        boolean result = job.waitForCompletion(true);
        System.exit(result?0:1);
    }
}
