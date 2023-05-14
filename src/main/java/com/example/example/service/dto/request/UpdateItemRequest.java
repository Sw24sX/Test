package com.example.example.service.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateItemRequest {

    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private Integer cost;
}