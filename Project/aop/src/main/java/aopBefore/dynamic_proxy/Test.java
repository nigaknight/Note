package aopBefore.dynamic_proxy;

import aopBefore.calculator_ordinary.ArithmeticCalculator;

/**
 * @author nigaknight
 * @date 2019/7/6 12:23
 */
public class Test {
    public static void main(String[] args) {
        ArithmeticCalculator target=new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy=new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
        System.out.println("直接调用ArithmeticCalculatorImpl类的add方法");
        int result=target.add(5,7);
        System.out.println("result:"+result);
        System.out.println("调用由代理类中由Proxy的静态方法返回的ArithmeticCalculator对象的add方法");
        int result2=proxy.add(5,7);
        System.out.println("result:"+result2);

    }
}
