package com.cj.flightmanager.controller;

import com.cj.flightmanager.service.BookOderService;
import com.cj.flightmanager.service.UserService;

import java.util.Scanner;

public class UserManagerView {
    public void userManager() {
        BookOderService bookOder = new BookOderService();
        Scanner scanner =new Scanner(System.in);
        System.out.println("=========用户界面=========");
        System.out.println("=========1.查询=========");
        System.out.println("=========2.订票=========");
        System.out.println("=========3.退票=========");
        System.out.println("=========4.个人信息=========");
        System.out.println("=========5.返回上一级=========");
        System.out.println("=========6.退出=========");
        System.out.println("请输入你要进行的操作");
        String in=scanner.next();
        switch (in){
            case "1":
                UserQueryFlightView userQueryFlightView = new UserQueryFlightView();
                userQueryFlightView.userQueryFlight();
                break;
            case "2":
                bookOder.bookFlight();
                break;
            case "3":
                bookOder.bookFlightBack();
                break;
            case "4":
                UserService userService = new UserService();
                userService.selectUserAllInformation();
                break;
            case "5":
                UserLoginView userLoginView=new UserLoginView();
                userLoginView.userLogin();
                break;
            case "6":
                System.exit(0);
                break;
            default:
                System.out.println("输入错误");
                break;
        }
        userManager();
    }
}
