package com.example.example.controller.advice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationErrorMessage {

    private String field;
    private String message;
}
