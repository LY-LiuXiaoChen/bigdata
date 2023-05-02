package com.cj.flightmanager.service;

import com.cj.flightmanager.dao.FlightDao;
import com.cj.flightmanager.domain.FlightInformation;

import java.util.List;
import java.util.Scanner;

public class FlightService {
    private FlightInformation flightInformation=new FlightInformation();
    private FlightDao flightDao=new FlightDao();
    private Scanner in=new Scanner(System.in);
    public void add() {
        System.out.println("请输入航班编号");
        flightInformation.setFlightId(in.nextInt());
        System.out.println("请输入飞机机型");
        flightInformation.setAirplaneModel(in.next());
        System.out.println("请输入机舱等级");
        flightInformation.setRoomClass(in.next());
        System.out.println("请输入起飞城市");
        flightInformation.setFromCity(in.next());
        System.out.println("请输入目标城市");
        flightInformation.setToCity(in.next());
        System.out.println("请输入起飞日期（yyyy-mm-dd）");
        String startDate=in.next();
        System.out.println("请输入起飞时间(00:00:00)");
        String startTime=in.next();
        flightInformation.setStartTime(startDate+" "+startTime);
        System.out.println("请输入到港日期");
        String endDate=in.next();
        System.out.println("请输入到港时间");
        String endTime=in.next();
        flightInformation.setEndTime(endDate+" "+endTime);
        System.out.println("票价");
        flightInformation.setPrice(in.nextDouble());
        System.out.println("总票数");
        flightInformation.setSumVotes(in.nextInt());
        System.out.println("余票");
        flightInformation.setRemainingVotes(in.nextInt());
        boolean result= flightDao.add(flightInformation);
        if(result){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    public void delete() {
        System.out.println("请输入要删除的航班编号");
        int flightId=in.nextInt();
        if(flightDao.flightExist(flightId)){
            boolean result= flightDao.delete(flightId);
            if(result){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("航班不存在！！！！");
        }

    }

    public void update() {
        System.out.println("请输入要修改的航班编号");
        int flightId=in.nextInt();
        if(flightDao.flightExist(flightId)){
            flightInformation.setFlightId(flightId);
            System.out.println("请输入飞机机型");
            flightInformation.setAirplaneModel(in.next());
            System.out.println("请输入机舱等级");
            flightInformation.setRoomClass(in.next());
            System.out.println("请输入起飞城市");
            flightInformation.setFromCity(in.next());
            System.out.println("请输入目标城市");
            flightInformation.setToCity(in.next());
            System.out.println("请输入起飞日期（yyyy-mm-dd）");
            String startDate=in.next();
            System.out.println("请输入起飞时间(00:00:00)");
            String startTime=in.next();
            flightInformation.setStartTime(startDate+" "+startTime);
            System.out.println("请输入到港日期");
            String endDate=in.next();
            System.out.println("请输入到港时间");
            String endTime=in.next();
            flightInformation.setEndTime(endDate+" "+endTime);
            System.out.println("票价");
            flightInformation.setPrice(in.nextDouble());
            System.out.println("总票数");
            flightInformation.setSumVotes(in.nextInt());
            System.out.println("余票");
            flightInformation.setRemainingVotes(in.nextInt());
            boolean result= flightDao.update(flightInformation);
            if(result){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
        }else {
            System.out.println("航班不存在！！！！");
        }
    }

    public void selectById() {
        System.out.println("请输入要查询的航班编号");
        int flightId=in.nextInt();
        FlightInformation result= flightDao.selectById(flightId);
        if(result!=null){
            System.out.println(result);
        }else {
            System.out.println("航班不存在");
        }
    }

    public void selectByFromToCity() {
        System.out.println("请输入起飞城市");
        String fromCity=in.next();
        System.out.println("请输入目标城市");
        String toCity=in.next();
        List<FlightInformation> result = flightDao.selectByFromToCity(fromCity, toCity);
        if(result.size()==0){
            System.out.println("航班不存在");
        }else {
            for (FlightInformation information : result) {
                System.out.println(information);
            }
        }
    }

    public void selectAll() {
        List<FlightInformation> result = flightDao.selectAll();
        if(result.size()==0){
            System.out.println("航班不存在");
        }else {
            for (FlightInformation information : result) {
                System.out.println(information);
            }
        }
    }
}
