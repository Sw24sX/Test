package com.example.example.advice;

import com.example.example.service.dto.response.ShopDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ExampleAdvice {

    @Pointcut("@annotation(com.example.example.advice.annotations.LogTimer)")
    public void pointcutExample() {

    }

    @SneakyThrows
    @Around("pointcutExample()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {

        log.info("Around before");
        var start = System.nanoTime();
        try {
            return joinPoint.proceed();
        } finally {
            var result = (System.nanoTime() - start) / 1000000;
            log.info("Processing time (ms): {}", result);
            log.info("Around after");
        }

    }

    @Before("pointcutExample()")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Before");
    }

    @After("pointcutExample()")
    public void afterAdvice(JoinPoint joinPoint) {
        log.info("After");
    }

    @AfterThrowing("pointcutExample()")
    public void afterThrowingAdvice(JoinPoint joinPoint) {
        log.info("AfterThrowing");
    }

    @AfterReturning(value = "pointcutExample()", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, ShopDto result) {
        log.info("AfterReturning");
        log.info("Shop dto: Id - {}", result.getId());
    }
}
