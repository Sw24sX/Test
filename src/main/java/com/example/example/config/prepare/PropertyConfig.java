package com.example.example.config.prepare;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:other.properties") //можем создать свой конфиг файл и зарегистрировать его
public class PropertyConfig {

}
