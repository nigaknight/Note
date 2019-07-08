package reflection;
/*
反射：就是通过class文件对象，去使用该文件中的成员变量、构造方法和成员方法
Person p= new Person()
使用p
要想这样使用，首先必须得到class文件对象，其实也就是得到Class类的对象
Class类：
  成员变量 Field
  构造方法 Constructor
  成员方法 Method

获取Class文件对象的方式：
A、Object类的getClass方法
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 方式1
        Person p=new Person();
        Class c=p.getClass();

        Person p2=new Person();
        Class c2=p2.getClass();

        System.out.println("1、使用getClass方法获取Class文件");
        System.out.println("c==c2:"+(c==c2));

        // 方式2
        Class c3=Person.class;
        System.out.println("2、使用.class文件的方法获取Class文件");
        System.out.println("c==c3:"+(c==c3));

        // 方式3：必须使用类的全路径（带包名）
        Class c4=Class.forName("reflection.Person");
        System.out.println("3、使用Class类的forName方法获取Class文件");
        System.out.println("c==c4:"+(c==c4));
    }
}
