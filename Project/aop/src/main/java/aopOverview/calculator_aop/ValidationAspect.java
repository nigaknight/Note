package aopOverview.calculator_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author nigaknight
 * @since 2019/7/7 11:14
 * 方法执行前验证参数的切面
 */
@Order(1)
@Component
@Aspect
public class ValidationAspect {
    @Before("aopOverview.calculator_aop.LoggingAspect.declareJoinPointExpression()")
    public void validationMethod(JoinPoint joinPoint){
        System.out.println("validate: "+ Arrays.asList(joinPoint.getArgs()));
    }
}
