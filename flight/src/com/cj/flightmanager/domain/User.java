package com.cj.flightmanager.domain;

public class User {
    private int userId; //  用户id
    private String userName;    //用户名
    private String password;    //密码
    private String trueName;    //真实姓名
    private String idCard;      //身份证号
    private String phone;       //手机号
    private double balance;     //余额

    public User() {
    }

    public User(int userId, String userName, String password, String trueName, String idCard, String phone, double balance) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.trueName = trueName;
        this.idCard = idCard;
        this.phone = phone;
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", trueName='" + trueName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                '}';
    }
}
