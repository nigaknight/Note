package aopOverview.base_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author nigaknight
 * @since 2019/7/6 13:50
 * 把这个类声明为一个切面，需要把该类放入到容器中，再声明为一个切面
 */

public class LoggingAspect {



    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+methodName+" begins with "+args);
    }


    public  void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends");
    }


    public  void afterReturnMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends with "+result);
    }


    public void afterThrowingMethod(JoinPoint joinPoint, NullPointerException e){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" occurs exception: "+e);
    }


}
