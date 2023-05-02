package test;

import java.sql.*;

public class JDBCTest02 {
    public static void main(String[] args) {
        //注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection conn=null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            //获取数据库连接
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123456");
            //获取数据库操作对象
            statement=conn.createStatement();
            //执行sql语句
            //String sql="select empno,sal from emp where ename="+"'ALLEN'";
            String sql="select empno,sal from emp where ename='ALLEN'";
            rs=statement.executeQuery(sql);
            //处理查询结果集
            while(rs.next()){
                String ename=rs.getString(1);
                String sal=rs.getString(2);
                System.out.println(ename+" "+sal);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //释放资源
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
