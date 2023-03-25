package com.example.example.config.prepare;

import com.example.example.controller.dto.ExampleDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeansConfig {

    @Bean(name = "exampleDto")
    @ConditionalOnProperty(prefix = "simple", name = "params", havingValue = "test")
    public ExampleDto exampleDtoWithTest() {
        return new ExampleDto("test", 10);
    }

    @Bean(name = "exampleDto")
    @ConditionalOnProperty(prefix = "simple", name = "params", havingValue = "other value")
    public ExampleDto exampleDtoWithOtherValue() {
        return new ExampleDto("other value", 11);
    }

    @Bean(name = "exampleDto")
    @ConditionalOnExpression("${simple.value} and ${simple.example} == 123")
    public ExampleDto exampleDtoByExpression() {
        return new ExampleDto("expression", 11);
    }

    @Bean(name = "exampleDto")
    @ConditionalOnMissingBean(ExampleDto.class)
    public ExampleDto exampleDtoDefault() {
        return new ExampleDto("miss", 11);
    }
}
