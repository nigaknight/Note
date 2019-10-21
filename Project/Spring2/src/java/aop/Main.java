package aop;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class Main {
    public static void main(String[] args) {
        Calculator calculator=new Calculator();
        int add = calculator.add(2, 3);
        System.out.println(add);
    }
}
