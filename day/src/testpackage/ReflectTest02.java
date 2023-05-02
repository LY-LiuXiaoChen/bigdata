package testpackage;
/*
* 通过反射机制调用对象的构造器
* 通过反射机制调用对象的方法
* */
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest02 {
    public static void main(String[] args) throws Exception{
        Class c=Class.forName("classpackage.Student");
        //获取Student的有参构造方法
        Constructor constructor= c.getDeclaredConstructor(String.class,String.class,int.class,boolean.class);
        //创建Student对象obj
        Object obj= constructor.newInstance("1111","张三",18,true);
        //获取Student中名为judge的方法
        Method method= c.getDeclaredMethod("judge", String.class, String.class, int.class, boolean.class);
        //调用obj对象的judge方法
        Object returnobj= method.invoke(obj,"1111","张三",18,true);
        //输出judge方法的返回值
        System.out.println(returnobj);
    }
}
