package com.cj.flightmanager.dao;

import com.cj.flightmanager.JDBCUtils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class LoginDao {
    public Boolean adminLogin(String name,String password){
        String sql="select count(*) from admin where admin_name=? and password=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            Number result = queryRunner.query(sql, new ScalarHandler<>(), name, password);
            if(result.intValue()>0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
