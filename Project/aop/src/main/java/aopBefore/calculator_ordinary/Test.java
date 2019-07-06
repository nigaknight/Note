package aopBefore.calculator_ordinary;

/**
 * @author nigaknight
 * @date 2019/7/6 11:49
 */
public class Test {
    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator=new ArithmeticCalculatorLoggingImpl();
        int result=arithmeticCalculator.add(3,5);
        System.out.println("result:"+result);
    }
}
