package com.cj.mapreduce.outputformat;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

public class logRecordWriter extends RecordWriter <Text, NullWritable>{

    private  FSDataOutputStream atguiguOut;
    private  FSDataOutputStream otherOut;

    public logRecordWriter(TaskAttemptContext job) {

        try {
            //获取文件系统对象
            FileSystem fs=FileSystem.get(job.getConfiguration());
            //创建流
            atguiguOut = fs.create(new Path("D:\\testoutput\\atguigu\\atguigu.log"));
            otherOut = fs.create(new Path("D:\\testoutput\\other\\other.log"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(Text key, NullWritable value) throws IOException, InterruptedException {
        //写
        String string = key.toString();
        if(string.contains("atguigu")){
            atguiguOut.writeBytes(string+"\n");
        }else {
            otherOut.writeBytes(string+"\n");
        }
    }

    @Override
    public void close(TaskAttemptContext context) throws IOException, InterruptedException {
        IOUtils.closeStream(atguiguOut);
        IOUtils.closeStream(otherOut);
    }
}
