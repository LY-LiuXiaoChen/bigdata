package com.cj.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * 客户端代码
 * 1.获取客户端对象
 * 2.执行相关操作命令
 * 3.关闭资源
 * HDFS zookeeper
 */
public class HdfsClient {

    private FileSystem fs;
    @Before
    public void init() throws URISyntaxException, IOException, InterruptedException {
        //连接的集群namenode地址
        URI uri = new URI("hdfs://hadoop102:8020");
        //获取配置文件
        Configuration configuration = new Configuration();
        configuration.set("dfs.replication","2");
        //获取用户
        String user="cj";
        //获取客户端对象
        fs = FileSystem.get(uri, configuration, user);
    }
    @After
    public void close() throws IOException {
        //关闭资源
        fs.close();
    }
    //创建目录
    @Test
    public void testMkdir() throws URISyntaxException, IOException, InterruptedException {

        //创建文件夹
        fs.mkdirs(new Path("/hadoopstudy1/hadoopstudy2"));
    }

    /**
     * 参数优先级：服务器默认配置hdfs-default.xml-->服务器自定义配置hdfs-site.xml-->在项目资源目录下的配置文件-->代码中的配置
     * @throws IOException
     */
    //上传文件
    @Test
    public void testPut() throws IOException {
        //参数
        //delsrc:表示是否删除源数据
        //overwrite:表示文件存在时，是否覆盖
        //srcs:源数据路径
        //dst:目标地址路径
        fs.copyFromLocalFile(false,true,new Path("C:\\Users\\a\\Desktop\\zt.txt"),new Path("/cj/hadoopstudy"));
    }

    //下载文件
    @Test
    public void testGet() throws IOException {
        //delsrc
        //src
        //dst
        //useRawLocalFileSystem:是否开启校验，false开启，true关闭
        fs.copyToLocalFile(false,new Path("/cj/hadoopstudy/zt.txt"),new Path("C:\\Users\\a\\Desktop"),true);
    }

    //删除文件
    @Test
    public void testRm() throws IOException {
        //path:路径
        //b:是否递归删除
        //删除文件
        //fs.delete(new Path("/output"),true);

        //删除空目录
       // fs.delete(new Path("/hadoopstudy1"),false);

        //删除非空目录
        fs.delete(new Path("/input"),true);
    }

    //文件重命名和移动
    @Test
    public void testMv() throws IOException {
        //path:原文件路径，
        //path1:目标路径
        //文件重命名
        //fs.rename(new Path("/cj/hadoopstudy/zt.txt"),new Path("/cj/hadoopstudy/遮天.txt"));

        //文件移动并重命名
        //fs.rename(new Path("/cj/hadoopstudy/遮天.txt"),new Path("/cj/zt.txt"));

        //目录更名
        fs.rename(new Path("/cj"),new Path("/chenjie"));
    }

    //获取文件详细信息
    @Test
    public void fileDetail() throws IOException {
        //path:路径
        //recursive:是否递归
        //获取文件所有信息，listFiles返回值为迭代器
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/chenjie"), true);
        //遍历
        while(listFiles.hasNext()){
            LocatedFileStatus status = listFiles.next();
            System.out.println("------------"+status.getPath()+"------------");
            System.out.println(status.getPermission());
            System.out.println(status.getOwner());
            System.out.println(status.getGroup());
            //文件大小-->Size
            System.out.println(status.getLen());
            //上次修改时间-->Last Modified
            System.out.println(status.getModificationTime());
            System.out.println(status.getReplication());
            System.out.println(status.getBlockSize());
            //文件名
            System.out.println(status.getPath().getName());

            //获取块信息
            BlockLocation[] blockLocations = status.getBlockLocations();
            System.out.println(Arrays.toString(blockLocations));
        }
    }
    // 文件和文件夹判断
    @Test
    public void testIsFile() throws IOException {
        FileStatus[] listStatus = fs.listStatus(new Path("/"));
        for (FileStatus status : listStatus) {
            if (status.isFile()) {
                System.out.println(status.getPath().getName() + "是文件");
            }else {
                System.out.println(status.getPath().getName() + "是目录");
            }
        }
    }
}
