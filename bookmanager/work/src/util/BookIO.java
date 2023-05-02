package util;
import domain.Book;
import java.io.*;
import java.util.HashMap;

public class BookIO {
    /*static{
        File file= new File("book");
        if(file.exists()==false){
            try {
                file.createNewFile();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }*/
    public void write(HashMap<String,Book> hashMap)  {
        FileOutputStream fileOutputStream= null;
        ObjectOutputStream oos= null;
        try {
            fileOutputStream = new FileOutputStream("book");
            oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(hashMap);
            oos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
    public HashMap<String,Book> read() {
        HashMap<String,Book> hashmap;
        ObjectInputStream ois= null;
        try {
            ois = new ObjectInputStream(new FileInputStream("book"));
            hashmap= (HashMap<String, Book>) ois.readObject();
            return hashmap;
        } catch (EOFException e){
            System.out.println("文件还没有数据，请先执行添加操作！！！！！！！！！！！！！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
       return null;
    }
}