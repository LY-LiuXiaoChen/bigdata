package com.cj.flightmanager.controller;

import java.util.Scanner;

public class AdminManagerView {
    public void adminManager(){
        System.out.println("=========管理员界面=============");
        System.out.println("=========1.航班信息管理=========");
        System.out.println("=========2.旅客信息管理（还未实现）=========");
        System.out.println("=========3.财务信息管理（还未实现）=========");
        System.out.println("=========4.返回初始界面（选择登录界面）===========");
        System.out.println("=========5.退出=========");
        System.out.println("请选择要进行的操作");
        Scanner scanner=new Scanner(System.in);
        String in=scanner.next();
        switch (in){
            case "1" :
                AdminFlightManagerView adminFlightManagerView = new AdminFlightManagerView();
                adminFlightManagerView.flightManager();
                break;
            case "2" :
                break;
            case "3" :
                break;
            case "4" :
                FilghtView filghtView=new FilghtView();
                filghtView.mainView();
                break;
            case "5" :
                System.exit(0);
                break;
            default:
                System.out.println("输入错误");
                break;
        }
        adminManager();
    }
}
