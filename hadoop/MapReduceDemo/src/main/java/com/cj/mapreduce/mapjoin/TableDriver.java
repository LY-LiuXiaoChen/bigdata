package com.cj.mapreduce.mapjoin;

import com.cj.mapreduce.reducejoin.TableBeanReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TableDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, URISyntaxException {
        Job job = new Job(new Configuration());

        job.setJarByClass(TableBean.class);

        job.setMapperClass(TableBeanMapper.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setOutputKeyClass(TableBean.class);
        job.setOutputValueClass(NullWritable.class);

        job.addCacheFile(new URI("file:///d:/testinput/input/tablecache/pd.txt"));

        FileInputFormat.setInputPaths(job,new Path("D:\\testinput\\input\\inputtable2"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\testoutput\\outputtable111"));

        boolean result = job.waitForCompletion(true);
        System.exit(result?0:1);

    }
}
