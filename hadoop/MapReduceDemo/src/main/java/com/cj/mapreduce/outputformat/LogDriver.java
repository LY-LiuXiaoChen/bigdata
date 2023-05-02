package com.cj.mapreduce.outputformat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


public class LogDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        Job job = new Job(new Configuration());
        job.setJarByClass(LogDriver.class);
        job.setMapperClass(LogMapper.class);
        job.setReducerClass(LogReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        job.setOutputFormatClass(LogOutputFormat.class);
        FileInputFormat.setInputPaths(job,new Path("D:\\testinput\\input\\inputoutputformat"));

        FileOutputFormat.setOutputPath(job,new Path("D:\\testoutput\\outputformat"));

        boolean resutl = job.waitForCompletion(true);
        System.exit(resutl?0:1);
    }
}
