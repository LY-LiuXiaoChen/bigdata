package com.cj.flightmanager.dao;

import com.cj.flightmanager.JDBCUtils.JDBCUtils;
import com.cj.flightmanager.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UserDao {
    public boolean add(User user) {
        String sql="insert into user values(?,?,?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int result = queryRunner.update(sql, user.getUserId(), user.getUserName(), user.getPassword(), user.getTrueName(), user.getIdCard(), user.getPhone(), user.getBalance());
            if(result>0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean userExist(int id){
        String sql="select count(*) from user where userid=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            Number result = queryRunner.query(sql, new ScalarHandler<>(), id);
            if(result.intValue()>0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login(int id, String password) {
        String sql="select count(*) from user where userid=? and password=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            Number result = queryRunner.query(sql, new ScalarHandler<>(), id, password);
            if(result.intValue()>0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User selectAll(int userId) {
        String sql="select userid as userId,username as userName,password,truename as trueName,id_card as idCard,phone,balance from user where userid=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            return queryRunner.query(sql,new BeanHandler<>(User.class),userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
