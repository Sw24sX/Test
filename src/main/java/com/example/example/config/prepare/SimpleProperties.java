package com.example.example.config.prepare;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "simple")
@ConfigurationPropertiesBinding
public class SimpleProperties {
    private String params;

    private Integer example;

    private Boolean value;

    private String exampleValueWithManyWorlds;
}
