package testpackage;
/*
* 通过反射机制调用对象的属性
* */
import java.lang.reflect.Field;

public class ReflectTest01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class c=Class.forName("classpackage.Student");
        //创建一个Student对象o
        Object o=c.newInstance();
        //根据属性名称获取Filed  获取no属性
        Field nofield=c.getDeclaredField("no");
        //给对象o的no属性赋值
        nofield.set(o,"1111");
        //获取对象o的no属性的值
        System.out.println(nofield.get(o));
        //根据属性名称获取Filed  获取name属性
        Field nameFiled= c.getDeclaredField("name");
        //打破封装
        nameFiled.setAccessible(true);
        //给对象o的name属性赋值
        nameFiled.set(o,"张三");
        //获取对象o的name属性的值
        System.out.println(nameFiled.get(o));
    }
}
