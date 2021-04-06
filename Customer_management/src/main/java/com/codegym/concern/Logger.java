package com.codegym.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class Logger {
    public void error() {
        System.out.println("[CMS] ERROR!");
    }

    @AfterThrowing(pointcut = "execution(public * com.codegym.service.ICustomerService.*(..))", throwing = "e")
    public void log(JoinPoint jp, Exception e){
        String className  = jp.getTarget().getClass().getSimpleName();
        String method = jp.getSignature().getName();
        String args  = Arrays.toString(jp.getArgs());
        System.out.printf("co loi xay ra: %s.%s%s: %s \n",className,method,args,e.getMessage());
    }
}
