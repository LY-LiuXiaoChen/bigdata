package controller;


import service.BookManager;

import java.util.Scanner;

public class MainView {
    public void chuShiHua() {
        BookManager bookManager=new BookManager();
        System.out.println("------------图书管理系统-----------");
        System.out.println("------------1.添加图书-----------");
        System.out.println("------------2.修改图书-----------");
        System.out.println("------------3.删除图书-----------");
        System.out.println("------------4.查询单本图书-----------");
        System.out.println("------------5.查询全部图书----------");
        System.out.println("------------6.退出----------");
        Scanner scanner= new Scanner(System.in);
        int i =scanner.nextInt();
        switch (i){
            case 1:
                bookManager.addBookManager();
                break;
            case 2:
                bookManager.updateBookManager();
                break;
            case 3:
                bookManager.deleteBookManager();
                break;
            case 4:
                bookManager.selectBookManager();
                break;
            case 5:
                bookManager.selectAllBookManager();
                break;
            case 6:
                return;
            default:
                System.out.println("输入错误，请重新输入");
                break;
        }
        chuShiHua();
    }
}
