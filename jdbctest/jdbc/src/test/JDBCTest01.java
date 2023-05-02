package test;

import java.sql.*;

public class JDBCTest01 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123456");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
           statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sql="select ename,sal from emp";
        try {
           rs= statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            while(rs.next()){
                String ename=rs.getString(1);
                String sal=rs.getString(2);
                System.out.println(ename+"  "+sal);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
