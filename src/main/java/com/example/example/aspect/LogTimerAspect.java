package com.example.example.aspect;

import com.example.example.service.dto.response.ItemDto;
import com.example.example.service.exception.ServiceException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogTimerAspect {

    @Pointcut("within(com.example.example.service.impl.ItemService)")
    public void examplePointcut() {

    }

    @Around("examplePointcut()")
    @SneakyThrows
    public Object timer(ProceedingJoinPoint joinPoint) {

        log.info("Around before");
        try{
            return joinPoint.proceed();
        } finally {
            log.info("Around after");
        }
    }

    @Before("examplePointcut()")
    public void before(JoinPoint joinPoint) {
        log.info("Log before");
    }

    @After("examplePointcut()")
    public void after(JoinPoint joinPoint) {
        log.info("Log after");
    }

    @AfterReturning(value = "examplePointcut()", returning = "returned")
    public void afterReturning(JoinPoint joinPoint, ItemDto returned) {
        log.info("Log after returning");
    }

    @AfterThrowing("examplePointcut()")
    public void afterThrowing(JoinPoint joinPoint) {
        log.info("Log throwing");
    }
}
