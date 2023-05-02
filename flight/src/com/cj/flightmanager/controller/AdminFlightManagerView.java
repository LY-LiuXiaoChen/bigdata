package com.cj.flightmanager.controller;

import com.cj.flightmanager.service.FlightService;

import java.util.Scanner;

public class AdminFlightManagerView {
    public void flightManager(){
        FlightService flightService = new FlightService();
        System.out.println("=========航班信息管理界面=============");
        System.out.println("=========1.添加航班信息=========");
        System.out.println("=========2.删除航班信息=========");
        System.out.println("=========3.修改航班信息=========");
        System.out.println("=========4.查询单个航班信息（by 航班id）===========");
        System.out.println("=========5.查询单个航班信息（by 始发地,目的地）===========");
        System.out.println("=========6.查询所有航班信息===========");
        System.out.println("=========7.返回上一级===========");
        System.out.println("=========8.退出=========");
        System.out.println("请选择要进行的操作");
        Scanner scanner=new Scanner(System.in);
        String in=scanner.next();
        switch (in) {
            case "1":
                flightService.add();
                break;
            case "2":
                flightService.delete();
                break;
            case "3":
                flightService.update();
                break;
            case "4":
                flightService.selectById();
                break;
            case "5":
                flightService.selectByFromToCity();
                break;
            case "6":
                flightService.selectAll();
                break;
            case "7":
                AdminManagerView adminManagerView = new AdminManagerView();
                adminManagerView.adminManager();
                break;
            case "8":
                System.exit(0);
                break;
            default:
                System.out.println("输入错误");
                break;
        }
        flightManager();
    }
}
