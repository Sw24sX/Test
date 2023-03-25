package com.example.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);

        // Имеет смысл, если передаются какие-либо аргументы при старте приложения
        // (если очень необходимо такое, то юзаем Apache Commons CLI)

//        var app = new SpringApplication(ExampleApplication.class);
//        app.setDefaultProperties(Collections.singletonMap("simple.params", args[1]));
//        app.run(args);
    }

}
