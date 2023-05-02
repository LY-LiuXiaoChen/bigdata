package com.cj.mapreduce.reducejoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class TableDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Job job = new Job(new Configuration());

        job.setJarByClass(TableBean.class);

        job.setMapperClass(TableBeanMapper.class);
        job.setReducerClass(TableBeanReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(TableBean.class);

        job.setOutputKeyClass(TableBean.class);
        job.setOutputValueClass(NullWritable.class);

        FileInputFormat.setInputPaths(job,new Path("D:\\testinput\\input\\inputtable"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\testoutput\\outputtable1"));

        boolean result = job.waitForCompletion(true);
        System.exit(result?0:1);

    }
}
