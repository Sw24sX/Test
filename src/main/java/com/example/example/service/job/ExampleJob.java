package com.example.example.service.job;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
@EnableAsync
public class ExampleJob {

    @SneakyThrows
    @Async
    @Scheduled(cron = "*/15 * * * * *")
    @SchedulerLock(name = "ExampleJob_logTask")
    public void logTask() {
        log.info("Task started at {}", LocalDateTime.now());
        Thread.sleep(10000);
    }
}
