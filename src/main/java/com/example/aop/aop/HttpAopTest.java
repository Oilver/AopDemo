package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class HttpAopTest {

    @Pointcut("@annotation(com.example.aop.annotation.Cheaker)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object checkAuth(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        if(null==request||(!request.getSession().getAttribute("token").equals("Dengjinhui"))){
            return "错误，你不是邓锦辉！";
        }
        return joinPoint.proceed();
    }

}
