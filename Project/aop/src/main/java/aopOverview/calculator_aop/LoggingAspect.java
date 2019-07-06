package aopOverview.calculator_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author nigaknight
 * @date 2019/7/6 13:50
 * 把这个类声明为一个切面，需要把该类放入到容器中，再声明为一个切面
 */
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public int aopOverview.calculator_aop.ArithmeticCalculator.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+methodName+" begins with "+args);
    }
}
