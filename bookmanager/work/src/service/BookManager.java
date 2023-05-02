package service;

import domain.*;
import dao.*;
import java.util.Scanner;

public class BookManager {
    Book book =new Book();
    BookOperate bookOperate=new BookOperate();
    Scanner scanner=new Scanner(System.in);
    public void addBookManager(){
        System.out.println("请输入图书编号");
        String id=scanner.next();
        System.out.println("请输入图书名字");
        String name=scanner.next();
        System.out.println("请输入图书价格");
        double price=scanner.nextDouble();
        bookOperate.addBook(id,name,price);
        System.out.println("添加图书成功！");
    }
    public void deleteBookManager(){
        System.out.println("请输入要删除的图书编号");
        String id=scanner.next();
        if(bookOperate.selectBookExist(id)){
            bookOperate.deleteBook(id);
            System.out.println("删除图书成功！");
        }else{
            System.out.println("该图书不存在，请输入正确图书编号：");
            deleteBookManager();
        }

    }
    public void updateBookManager() {
        System.out.println("请输入要修改的图书编号");
        String id=scanner.next();
        if(bookOperate.selectBookExist(id)){
            System.out.println("请输入修改后的图书名字");
            String name=scanner.next();
            System.out.println("请输入修改后的图书价格");
            double price=scanner.nextDouble();
            bookOperate.updateBook(id,name,price);
            System.out.println("修改图书成功，修改后的信息为：");
            bookOperate.selectBook(id);
        }else{
            System.out.println("该图书不存在，请输入正确图书编号：");
            updateBookManager();
        }


    }
    public void selectBookManager() {
        System.out.println("请输入要查询的图书编号");
        String id=scanner.next();
        if(bookOperate.selectBookExist(id)){
            bookOperate.selectBook(id);
        }else {
            System.out.println("该图书不存在，请输入正确图书编号：");
            selectBookManager();
        }
    }
    public void selectAllBookManager() {
        bookOperate.selectAllBook();
    }
}
