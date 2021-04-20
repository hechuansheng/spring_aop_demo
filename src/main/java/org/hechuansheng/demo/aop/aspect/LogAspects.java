package org.hechuansheng.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 使用AOP为方法添加日志
 * @author : hechuansheng
 * @date : 2021/4/20 10:30
 * @description : 日志切面
 */
@Aspect
@Component
public class LogAspects {

    @Pointcut("execution(public * org.hechuansheng.demo.aop.controller.*.*(..)) && args(param1, param2)")
    public void pointCut(String param1, String param2) {
    }

    @Before(value = "pointCut(arg1, arg2)")
    public void before(JoinPoint joinPoint, String arg2, String arg1) {
        System.out.println("=================before====================");
        System.out.println("joinPoint.getArgs() = " + Arrays.asList(joinPoint.getArgs()));
        System.out.println("joinPoint.getSignature() = " + joinPoint.getSignature());
        System.out.println("arg1: " + arg1);
        System.out.println("arg2: " + arg2);
    }

    @After("execution(public * org.hechuansheng.demo.aop.controller.*.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("=================after====================");
        System.out.println("joinPoint.getSignature() = " + joinPoint.getSignature());
    }

    @AfterReturning(value = "execution(public * *(..))", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        System.out.println("=================afterReturning====================");
        System.out.println("joinPoint.getSignature() = " + joinPoint.getSignature());
        System.out.println("returnValue = " + returnValue);

    }

    @AfterThrowing(value = "execution(public * org.hechuansheng.demo.aop..*(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception) {
        System.out.println("=================afterThrowing====================");
        System.out.println("joinPoint.getSignature() = " + joinPoint.getSignature());
        System.out.println("exception = " + exception.getMessage());

    }
}
