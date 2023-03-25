package com.example.example.config.prepare;

import com.example.example.controller.dto.ExampleDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller

public class ProfileExampleController {

    @Value("${profile.value}")
    private String name;

    @Bean("profile")
    @Profile("dev")
    public ExampleDto profile() {
        return new ExampleDto(name, 10);
    }

    @Bean("profile")
    @Profile("test")
    public ExampleDto profileDefault() {
        return new ExampleDto(name, 10);
    }
}
