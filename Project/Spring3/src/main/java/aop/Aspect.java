package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nigaknight
 * @time 2019/10/2
 **/
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Before("execution(public int add(int,int ))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        List<Object> args= Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+methodName+" start with args "+args);
    }
}
