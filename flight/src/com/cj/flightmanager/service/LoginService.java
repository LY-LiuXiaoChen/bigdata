package com.cj.flightmanager.service;

import com.cj.flightmanager.dao.LoginDao;

public class LoginService {

    public boolean adminLogin(String name, String password) {
        LoginDao loginDao = new LoginDao();
        return loginDao.adminLogin(name, password);
    }
}
