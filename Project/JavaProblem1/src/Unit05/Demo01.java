package Unit05;

/**
 * @author nigaknight
 * @time 2019/8/21
 **/
public class Demo01 {
    static int s; // 类变量
    int i; // 实例变量
    int j; // 实例变量
    {
        int i=1; // 静态代码块中的局部变量
        i++;
        j++;
        s++;
    }
    public void test(int j){ // 形参，局部变量
        i++;
        j++;
        s++;
    }

    public static void main(String[] args) {
        Demo01 d1=new Demo01(); // 局部变量d1
        Demo01 d2=new Demo01(); // 局部变量d2
        d1.test(10);
        d1.test(20);
        d2.test(30);
        System.out.println(d1.i+","+d1.j+","+d1.s);
        System.out.println(d2.i+","+d2.j+","+d2.s);
    }
}
