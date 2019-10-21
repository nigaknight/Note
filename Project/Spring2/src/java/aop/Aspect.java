package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Before("execution(public int add(int,int))")
    public void beforeMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("The method "+name+" begins with args "+args);
    }
}
