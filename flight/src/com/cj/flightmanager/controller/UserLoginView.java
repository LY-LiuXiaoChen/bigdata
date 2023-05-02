package com.cj.flightmanager.controller;

import com.cj.flightmanager.service.UserService;

import java.util.Scanner;

public class UserLoginView {
    public void userLogin(){
        UserService userService = new UserService();
        System.out.println("==========用户登录界面============");
        System.out.println("========1.注册=========");
        System.out.println("========2.登录=========");
        System.out.println("========3.返回上一级=========");
        System.out.println("========4.退出=========");
        System.out.println("请输入您要进行的操作");
        Scanner scanner=new Scanner(System.in);
        String in = scanner.next();
        switch (in){
            case "1":
                userService.register();
                break;
            case "2":
                userService.login();
                break;
            case "3":
                FilghtView filghtView = new FilghtView();
                filghtView.mainView();
                break;
            case "4":
                System.exit(0);
                break;
            default:
                System.out.println("输入错误");
                break;
        }
    userLogin();
    }
}
