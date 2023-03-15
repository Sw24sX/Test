package com.example.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExampleDto {

    @JsonProperty("customName")
    private String name;
    private Integer age;
}
