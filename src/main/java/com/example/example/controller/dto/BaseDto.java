package com.example.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;

public abstract class BaseDto {
    @JsonGetter
    public abstract String getType();
}

