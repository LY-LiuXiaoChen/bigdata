package com.cj.flightmanager.controller;

import java.util.Scanner;

public class FilghtView {
    public void mainView(){
        System.out.println("====================欢迎使用航空系统===================");
        System.out.println("请选择要进行的操作");
        System.out.println("1.用户登录\t2.管理员登录\t3.退出");
        Scanner scanner =new Scanner(System.in);
        String in =scanner.next();
        switch (in){
            case "1" :
                UserLoginView userLoginView = new UserLoginView();
                //
                userLoginView.userLogin();
                break;
            case "2" :
                AdminLoginView adminLoginView = new AdminLoginView();
                //调用方法
                adminLoginView.adminLogin();

                break;
            case "3" :
                System.exit(0);
                break;
            default:
                System.out.println("输入错误");
                mainView();
                break;
        }
    }
}
