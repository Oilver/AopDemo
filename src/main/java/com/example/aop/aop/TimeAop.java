package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimeAop {

    @Pointcut("within(com.example.aop.web.service.impl.TestAopServiceImpl)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object methodInvokeExpiredTime(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 开始
        Object retVal = pjp.proceed();
        stopWatch.stop();
        // 结束

        System.out.println(stopWatch.getTotalTimeMillis());

        return retVal;
    }
}
