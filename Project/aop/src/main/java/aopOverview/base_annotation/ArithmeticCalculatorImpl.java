package aopOverview.base_annotation;

import org.springframework.stereotype.Component;

/**
 * @author nigaknight
 * @date 2019/7/6 11:43
 */

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    public int add(int i, int j) {
        int result=i+j;
        return result;
    }

    public int sub(int i, int j) {
        int result=i-j;
        return result;
    }

    public int mul(int i, int j) {
        int result=i*j;
        return result;
    }

    public int div(int i, int j) {
        int result=i/j;
        return result;
    }
}
