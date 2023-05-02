package com.cj.flightmanager.controller;

import com.cj.flightmanager.service.LoginService;

import java.util.Scanner;

public class AdminLoginView {
    Scanner scanner =new Scanner(System.in);
    public void adminLogin(){
        System.out.println("==========管理员登录============");
        System.out.println("请输入您的用户名");
        String name=scanner.next();
        System.out.println("请输入您的密码");
        String password=scanner.next();
        LoginService login = new LoginService();
        boolean result=login.adminLogin(name,password);
        if (result){
            System.out.println("登陆成功");
            AdminManagerView adminManagerView = new AdminManagerView();
            adminManagerView.adminManager();
        }else {
            System.out.println("登录失败");
            adminLogin();
        }
    }
}
