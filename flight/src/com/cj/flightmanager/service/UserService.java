package com.cj.flightmanager.service;

import com.cj.flightmanager.controller.UserManagerView;
import com.cj.flightmanager.dao.UserDao;
import com.cj.flightmanager.domain.User;
import com.cj.flightmanager.controller.UserLoginView;

import java.util.Scanner;

public class UserService {
    private Scanner in = new Scanner(System.in);
    private User user = new User();
    private UserDao userDao = new UserDao();
    public static int userId;
    public void register() {
        System.out.println("=========注册=========");
        do {
            System.out.println("请输入您要注册的id");
            int id = in.nextInt();
            if (userDao.userExist(id)) {
                System.out.println("id已存在，请更换id");
            } else {
                user.setUserId(id);
                break;
            }
        } while (true);

        System.out.println("请输入您要注册的用户名");
        user.setUserName(in.next());

        do {
            System.out.println("请输入您要设置的密码");
            String firstPassword = in.next();
            System.out.println("请再次输入您要设置的密码");
            String secondPassword = in.next();
            if (!firstPassword.equals(secondPassword)) {
                System.out.println("两次密码不一样");
            } else {
                user.setPassword(firstPassword);
                break;
            }
        } while (true);
        System.out.println("请输入真实姓名");
        user.setTrueName(in.next());
        System.out.println("请输入身份证号");
        user.setIdCard(in.next());
        System.out.println("请输入手机号");
        user.setPhone(in.next());
        System.out.println("请输入充值的金额");
        user.setBalance(in.nextDouble());
        boolean result = userDao.add(user);
        if (result) {
            System.out.println("注册成功");
            UserLoginView userLoginView = new UserLoginView();
            userLoginView.userLogin();

        } else {
            System.out.println("注册失败");
        }
    }

    public void login() {
        System.out.println("==========用户登录============");
        System.out.println("请输入您的用户id");
        int id = in.nextInt();
        userId=id;
        System.out.println("请输入您的密码");
        String password = in.next();
        boolean result = userDao.login(id, password);
        if(result){
            System.out.println("登陆成功");
            UserManagerView userManagerView = new UserManagerView();
            userManagerView.userManager();
        }else {
            System.out.println("登录失败");
            login();
        }
    }

    public void selectUserAllInformation() {
        user=userDao.selectAll(userId);
        System.out.println(user);
    }
}
