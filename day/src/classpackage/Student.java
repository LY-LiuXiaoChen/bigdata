package classpackage;

public class Student {
    public String no;
    protected String name;
    private int age;
    boolean sex;
    public static final double PI=3.141592653;

    public Student() {
    }

    public Student(String no, String name, int age, boolean sex) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public boolean judge(String no, String name, int age, boolean sex){
        if(this.no.equals(no)&&this.name.equals(name)&&this.age==age&&this.sex==sex){
            System.out.println("你找对人了，我就是你要找的"+name);
            return true;
        }else {
            System.out.println("你找错人了，我不是你要找的人");
            return false;
        }
    }
}
