package aopOverview.calculator_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author nigaknight
 * @since 2019/7/6 13:50
 * 把这个类声明为一个切面，需要把该类放入到容器中，再声明为一个切面
 */
@Aspect
@Component
public class LoggingAspect {

/*    // 声明该方法是一个前置通知，在目标方法开始之前执行
    @Before("execution(public int aopOverview.calculator_aop.ArithmeticCalculator.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+methodName+" begins with "+args);
    }

    // 声明该方法是一个后置通知（无论是否发生异常），在目标方法开始之后执行
    @After("execution(public int aopOverview.calculator_aop.ArithmeticCalculator.*(int,int))")
    public  void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends");
    }

    // 声明该方法是一个返回通知，返回通知是可以访问到方法的返回值的
    @AfterReturning(value = "execution(public int aopOverview.calculator_aop.ArithmeticCalculator.*(int,int))",returning = "result")
    public  void afterReturnMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends with "+result);
    }

    // 在目标方法出现异常时会执行的代码，可以访问到异常对象，且可以指定出现特定异常时执行通知代码
    @AfterThrowing(value = "execution(public int aopOverview.calculator_aop.ArithmeticCalculator.*(int,int))",throwing = "e")
    public void afterThrowingMethod(JoinPoint joinPoint, NullPointerException e){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" occurs exception: "+e);
    }*/


}
