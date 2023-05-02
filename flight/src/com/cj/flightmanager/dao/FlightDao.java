package com.cj.flightmanager.dao;

import com.cj.flightmanager.JDBCUtils.JDBCUtils;
import com.cj.flightmanager.domain.FlightInformation;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class FlightDao {
    public boolean add(FlightInformation f) {
        String sql="insert into flight_information values(?,?,?,?,?,?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int result = queryRunner.update(sql, f.getFlightId(), f.getAirplaneModel(), f.getRoomClass(), f.getFromCity(), f.getToCity(), f.getStartTime(),
                    f.getEndTime(), f.getPrice(), f.getSumVotes(), f.getRemainingVotes());
            if (result>0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(int flightId) {
        String sql="delete from flight_information where flight_id=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int result = queryRunner.update(sql, flightId);
            if (result>0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean flightExist(int flightId){
        String sql="select count(*) from flight_information where flight_id=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            Number result = queryRunner.query(sql, new ScalarHandler<>(), flightId);
            if(result.intValue()>0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(FlightInformation f) {
        String sql="update flight_information set airplane_model=?,room_class=?,from_city=?,to_city=?,start_time=?," +
                "end_time=?,price=?,sum_votes=?,remaining_votes=? where flight_id=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            int result = queryRunner.update(sql, f.getAirplaneModel(), f.getRoomClass(), f.getFromCity(), f.getToCity(), f.getStartTime(),
                    f.getEndTime(), f.getPrice(), f.getSumVotes(), f.getRemainingVotes(),f.getFlightId());
            if (result>0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public FlightInformation selectById(int flightId) {
        String sql="select flight_id as 'flightId'," +
                "airplane_model as 'airplaneModel'," +
                "room_class as 'roomClass'," +
                "from_city as 'fromCity'," +
                "to_city as 'toCity'," +
                "start_time as 'startTime'," +
                "end_time as 'endTime'," +
                "price as 'price'," +
                "sum_votes as 'sumVotes'," +
                "remaining_Votes as 'remainingVotes'" +
                " from flight_information where flight_id=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            return queryRunner.query(sql, new BeanHandler<>(FlightInformation.class), flightId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FlightInformation> selectByFromToCity(String fromCity, String toCity) {
        String sql="select flight_id as 'flightId'," +
                "airplane_model as 'airplaneModel'," +
                "room_class as 'roomClass'," +
                "from_city as 'fromCity'," +
                "to_city as 'toCity'," +
                "start_time as 'startTime'," +
                "end_time as 'endTime'," +
                "price as 'price'," +
                "sum_votes as 'sumVotes'," +
                "remaining_Votes as 'remainingVotes'" +
                " from flight_information where from_city=? and to_city=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<FlightInformation> result = null;
        try {
            result = queryRunner.query(sql, new BeanListHandler<>(FlightInformation.class), fromCity, toCity);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FlightInformation> selectAll() {
        String sql="select flight_id as 'flightId'," +
                "airplane_model as 'airplaneModel'," +
                "room_class as 'roomClass'," +
                "from_city as 'fromCity'," +
                "to_city as 'toCity'," +
                "start_time as 'startTime'," +
                "end_time as 'endTime'," +
                "price as 'price'," +
                "sum_votes as 'sumVotes'," +
                "remaining_Votes as 'remainingVotes'" +
                " from flight_information";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<FlightInformation> result = null;
        try {
            result = queryRunner.query(sql, new BeanListHandler<>(FlightInformation.class));
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
