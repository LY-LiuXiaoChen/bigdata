package test;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCTest03 {
    public static void main(String[] args) {

        ResourceBundle resourceBundle=ResourceBundle.getBundle("resource/db");
        String driver=resourceBundle.getString("driver");
        String url=resourceBundle.getString("url");
        String user=resourceBundle.getString("user");
        String password=resourceBundle.getString("password");
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet rs=null;
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,password);
            String sql="select ename,sal,deptno from emp where ename like ?";
            statement=conn.prepareStatement(sql);
            statement.setString(1,"%a%");
            rs=statement.executeQuery();
            while(rs.next()){
                String ename1=rs.getString(1);
                String sal1=rs.getString(2);
                String deptno1=rs.getString(3);
                System.out.println(ename1+" "+sal1+" "+deptno1);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
