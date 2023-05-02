package com.cj.mapreduce.writablecomparable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlowBean implements WritableComparable<FlowBean> {
    private long upFlow;
    private long downFlow;
    private long totalFlow;

    public FlowBean() {
    }

    public long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(long upFlow) {
        this.upFlow = upFlow;
    }

    public long getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(long downFlow) {
        this.downFlow = downFlow;
    }

    public long getTotalFlow() {
        return totalFlow;
    }

    public void setTotalFlow(long totalFlow) {
        this.totalFlow = totalFlow;
    }
    public void setTotalFlow() {
        this.totalFlow = this.upFlow+this.downFlow;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(upFlow);
        out.writeLong(downFlow);
        out.writeLong(totalFlow);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.upFlow = in.readLong();
        this.downFlow = in.readLong();
        this.totalFlow = in.readLong();
    }

    @Override
    public String toString() {
        return upFlow +"\t" + downFlow +"\t" + totalFlow ;
    }


    @Override
    public int compareTo(FlowBean o) {
        if(this.totalFlow>o.totalFlow){
            return -1;
        }else if(this.totalFlow<o.totalFlow){
            return 1;
        }else {
            if (this.upFlow>o.upFlow){
                return -1;
            }else if(this.upFlow<o.upFlow){
                return 1;
            }else {
                return 0;
            }
        }
    }
}
