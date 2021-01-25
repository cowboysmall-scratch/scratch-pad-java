package com.cowboysmall.scratch.bionic.question1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAOP {

    @Autowired
    private Logger logger;

    @Before("execution(@LogExecution public * *(..))")
    public void loggingAdvice(JoinPoint jp) {

        logger.log(jp.getSignature().getName());
    }
}
