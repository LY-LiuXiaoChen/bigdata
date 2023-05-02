package com.cj.mapreduce.reducejoin;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class TableBeanMapper extends Mapper<LongWritable, Text,Text,TableBean> {

    private String fileName;
    private Text outKey=new Text();
    private TableBean outValue=new TableBean();

    @Override
    protected void setup(Mapper<LongWritable, Text, Text, TableBean>.Context context) throws IOException, InterruptedException {
        InputSplit split = context.getInputSplit();
        FileSplit inputSplit = (FileSplit) split;
        fileName = inputSplit.getPath().getName();
        System.out.println(fileName);
    }

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, TableBean>.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if(fileName.contains("order")){
            String[] split = line.split("\t");
            outKey.set(split[1]);
            outValue.setId(split[0]);
            outValue.setPid(split[1]);
            outValue.setAmount(Integer.parseInt(split[2]));
            outValue.setpName("");
            outValue.setFlag("order");
        }else {
            String[] split = line.split("\t");
            outKey.set(split[0]);
            outValue.setId("");
            outValue.setPid(split[0]);
            outValue.setAmount(0);
            outValue.setpName(split[1]);
            outValue.setFlag("pd");
        }
        context.write(outKey,outValue);
    }
}
