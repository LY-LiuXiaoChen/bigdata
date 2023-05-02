package dao;
import java.util.HashMap;
import domain.Book;
import util.*;

public class BookOperate {
    private BookIO bio=new BookIO() ;
    private static HashMap <String,Book> bookHashMap=new HashMap<>();
    public void addBook(String id,String name,double price)  {
        Book book=new Book();
        book.setId(id);
        book.setName(name);
        book.setPrice(price);
        bookHashMap.put(id,book);
        bio.write(bookHashMap);
    }
    public void deleteBook(String id) {
        bookHashMap=bio.read();
        bookHashMap.remove(id);
        bio.write(bookHashMap);
    }
    public void updateBook(String id, String name, double price) {
        bookHashMap=bio.read();
        Book book=new Book();
        book.setId(id);
        book.setName(name);
        book.setPrice(price);
        bookHashMap.put(id,book);
        bio.write(bookHashMap);
    }
    public void selectBook(String id)  {
        bookHashMap=bio.read();
        System.out.println(bookHashMap.get(id));
    }
    public void selectAllBook()  {
        bookHashMap=bio.read();
        for(Object key:bookHashMap.keySet()){
            Object value=bookHashMap.get(key);
            System.out.println(value);
        }

    }
    public boolean selectBookExist(String id) {
        bookHashMap=bio.read();
        if(bookHashMap.containsKey(id)){
            return true;
        }else {
            System.out.println("这本书不存在！！！");
            return false;
        }
    }
}
