package aop;

import org.springframework.stereotype.Component;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
@Component
public class Calculator {
    public int add(int i,int j){
        return i+j;
    }
}
