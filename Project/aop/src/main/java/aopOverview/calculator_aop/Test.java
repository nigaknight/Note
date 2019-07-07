package aopOverview.calculator_aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nigaknight
 * @date 2019/7/6 13:53
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("calculator-aop.xml");
        ArithmeticCalculator calculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

        int result=calculator.add(5,7);
        System.out.println("result:"+result);

        result=calculator.div(1000,0);
        System.out.println("result:"+result);
    }
}
