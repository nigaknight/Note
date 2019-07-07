package aopOverview.calculator_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author nigaknight
 * @since 2019/7/7 10:47
 * 环绕通知：需要携带ProceedingJoinPoint类型的参数
 * 环绕通知类似于动态代理的全过程，ProceedingJoinPoint类型的参数可以决定是否执行目标方法
 * 环绕通知必须有返回值，返回值即为目标方法的返回值
 */
@Component
@Aspect
public class LoggingAspect2 {
/*    @Around(value = "execution(public int aopOverview.calculator_aop.ArithmeticCalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        Object result=null;
        String methodName=joinPoint.getSignature().getName();

        try {
            // 前置通知
            System.out.println("The method "+ methodName+" begins with "+ Arrays.asList(joinPoint.getArgs()));
            result= joinPoint.proceed();
            // 返回通知
            System.out.println("The method "+methodName+" ends with "+result);
        } catch (Throwable throwable) {
            // 异常通知
            System.out.println("The method "+methodName+" occurs exception: "+throwable);
            throw new RuntimeException(throwable);
        }finally {
            // 后置通知
            System.out.println("The method "+methodName+" ends");
        }
        return result;
    }*/
}
