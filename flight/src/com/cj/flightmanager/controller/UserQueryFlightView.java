package com.cj.flightmanager.controller;

import com.cj.flightmanager.service.FlightService;

import java.util.Scanner;

public class UserQueryFlightView {
    public void userQueryFlight() {
        FlightService flightService = new FlightService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("===========用户航班查询页面==============");
        System.out.println("=========1.查询单个航班信息（by 航班id）===========");
        System.out.println("=========2.查询单个航班信息（by 始发地,目的地）===========");
        System.out.println("=========3.查询所有航班信息===========");
        System.out.println("=========4.返回上一级===========");
        System.out.println("=========5.退出=========");
        System.out.println("请输入你要进行的操作");
        String in=scanner.next();
        switch (in){
            case "1":
                flightService.selectById();
                break;
            case "2":
                flightService.selectByFromToCity();
                break;
            case "3":
                flightService.selectAll();
                break;
            case "4":
                UserManagerView userManagerView = new UserManagerView();
                userManagerView.userManager();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("输入错误");
                break;
        }
        userQueryFlight();
    }
}
